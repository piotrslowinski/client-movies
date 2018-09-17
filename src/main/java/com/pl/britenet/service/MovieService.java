package com.pl.britenet.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.pl.britenet.model.Credits;
import com.pl.britenet.model.Movie;
import com.pl.britenet.model.ReviewResultsPage;
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
        Optional<Movie> movieOptional = movieFinder.getById(movieId);
        if (!movieOptional.isPresent()) {
            throw new NoSuchElementException("cannot find movie with given id");
        }
        return movieOptional.get();
    }

    public Credits getCreditsByMovieId(Integer movieId){
        Optional<Credits> creditsOptional = movieFinder.getCredits(movieId);
        if (!creditsOptional.isPresent()) {
            throw new NoSuchElementException("cannot find credits for movie with given id");
        }
        return creditsOptional.get();
    }

    public ReviewResultsPage getReviewsByMovieId(Integer movieId) {
        Optional<ReviewResultsPage> resultsPage = movieFinder.getReviews(movieId);
        if (!resultsPage.isPresent()) {
            throw new NoSuchElementException("cannot find reviews for movie with given id");
        }
        return  resultsPage.get();
    }
}
