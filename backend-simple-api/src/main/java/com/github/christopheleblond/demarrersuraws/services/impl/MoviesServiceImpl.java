package com.github.christopheleblond.demarrersuraws.services.impl;

import com.github.christopheleblond.demarrersuraws.model.Movie;
import com.github.christopheleblond.demarrersuraws.repositories.MoviesRepository;
import com.github.christopheleblond.demarrersuraws.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {

    private MoviesRepository moviesRepository;

    private MoviesServiceImpl(@Qualifier("mysql") MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Override
    public List<Movie> findAllMovies(String sort) {
        return moviesRepository.findAllMovies(sort);
    }

    @Override
    public List<Movie> searchByQuery(String query, String sort) {
        return moviesRepository.search(query, sort);
    }
}
