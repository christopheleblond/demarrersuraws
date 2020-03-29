package com.github.christopheleblond.demarrersuraws.web;

import com.github.christopheleblond.demarrersuraws.model.Movie;
import com.github.christopheleblond.demarrersuraws.services.MoviesService;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {

    private MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/")
    public String health() {
        return "{\"status\": \"OK\"}";
    }

    @GetMapping("/movies")
    public List<Movie> findAllMovies(@RequestParam(required = false, name = "sort") @DefaultValue("title") String sort) {
        return moviesService.findAllMovies(sort);
    }

    @GetMapping("/movies/search")
    public List<Movie> search(@RequestParam("q") String query, @RequestParam(required = false, name = "sort") @DefaultValue("title") String sort) {
        return this.moviesService.searchByQuery(query, sort);
    }
}
