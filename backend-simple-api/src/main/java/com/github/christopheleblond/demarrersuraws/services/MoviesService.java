package com.github.christopheleblond.demarrersuraws.services;

import com.github.christopheleblond.demarrersuraws.model.Movie;

import java.util.List;

public interface MoviesService {

    List<Movie> findAllMovies(String sort);

    List<Movie> searchByQuery(String query, String sort);
}
