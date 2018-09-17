package com.pl.britenet.controller;

import com.pl.britenet.model.Credits;
import com.pl.britenet.model.Movie;
import com.pl.britenet.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable Integer movieId) {
        return movieService.getMovieById(movieId);
    }

    @GetMapping("/{movieId}/credits")
    public Credits getCreditsByMOvieId(@PathVariable Integer movieId) {
        return movieService.getCreditsByMOvieId(movieId);
    }
}
