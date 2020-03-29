package com.github.christopheleblond.demarrersuraws.repositories.impl;

import com.github.christopheleblond.demarrersuraws.model.Movie;
import com.github.christopheleblond.demarrersuraws.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Qualifier("mysql")
@Repository
public class MoviesMySQLRepositoryImpl implements MoviesRepository {

    private JdbcTemplate jdbcTemplate;

    public MoviesMySQLRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> findAllMovies(String sort) {
        return jdbcTemplate.query("SELECT * FROM movies", (rs, index) -> new Movie());
    }

    @Override
    public List<Movie> search(String query, String sort) {
        return null;
    }
}
