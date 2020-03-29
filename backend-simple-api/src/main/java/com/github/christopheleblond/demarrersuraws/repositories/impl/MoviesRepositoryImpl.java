package com.github.christopheleblond.demarrersuraws.repositories.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.christopheleblond.demarrersuraws.model.Movie;
import com.github.christopheleblond.demarrersuraws.repositories.MoviesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MoviesRepositoryImpl implements MoviesRepository {

    public static final Logger LOGGER = LoggerFactory.getLogger(MoviesRepositoryImpl.class);

    private List<Movie> movies = new ArrayList<>();

    private Map<String, Comparator<Movie>> sorts = new HashMap<>();

    @Value("classpath:movies.json")
    private Resource moviesDataFile;

    public MoviesRepositoryImpl() throws IOException {
        sorts.put("title", new Comparator<Movie>() {
            @Override
            public int compare(Movie a, Movie b) {
                if(StringUtils.isEmpty(a.getOriginalTitle())) {
                    return a.getTitle().compareToIgnoreCase(b.getTitle());
                }else{
                    return a.getOriginalTitle().compareToIgnoreCase(b.getTitle());
                }
            }
        });

        sorts.put("years", new Comparator<Movie>() {
            @Override
            public int compare(Movie a, Movie b) {
                return a.getYear() - b.getYear();
            }
        });

        sorts.put("rating", new Comparator<Movie>() {
            @Override
            public int compare(Movie a, Movie b) {
                return (int) a.getRating() - (int) b.getRating();
            }
        });
    }

    @PostConstruct
    private void loadData() throws IOException {

        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        this.movies = Arrays.asList(mapper.readValue(moviesDataFile.getInputStream(), Movie[].class));

        LOGGER.info("Data loaded: {} movies", movies.size());
    }

    private List<Movie> sortBy(List<Movie> movies, String sort) {
        Comparator<Movie> sorting = sorts.get(sort);
        if(sorting == null) {
            sorting = sorts.get("title");
        }

        movies.sort(sorting);

        return movies;

    }

    @Override
    public List<Movie> findAllMovies(String sort) {

        List<Movie> movies = new ArrayList<>();
        movies.addAll(this.movies);

        sortBy(movies, sort);

        return movies;
    }

    @Override
    public List<Movie> search(String query, String sort) {

        LOGGER.info("Search for " + query);

        List<Movie> movies = new ArrayList<>();
        movies.addAll(this.movies);

        sortBy(movies, sort);

        return movies.stream()
                .filter(m -> (m.getTitle() + "," + m.getOriginalTitle() + "," + m.getActors()).toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
