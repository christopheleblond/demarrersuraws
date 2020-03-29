package com.github.christopheleblond.demarrersuraws.repositories;

import com.github.christopheleblond.demarrersuraws.model.Movie;

import java.util.List;

public interface MoviesRepository {

    List<Movie> findAllMovies(String sort);

    List<Movie> search(String query, String sort);
}
