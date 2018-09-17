package com.pl.britenet.service;

import com.pl.britenet.model.Credits;
import com.pl.britenet.model.Movie;
import com.pl.britenet.util.MovieFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieFinder movieFinder;

    @Autowired
    public MovieService(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public Movie getMovieById(Integer movieId) {
        return movieFinder.getById(movieId);
    }

    public Credits getCreditsByMOvieId(Integer movieId){
        return movieFinder.getCredits(movieId);
    }
}
