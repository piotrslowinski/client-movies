package com.pl.britenet.service;

import com.pl.britenet.model.Credits;
import com.pl.britenet.model.Movie;
import com.pl.britenet.model.ReviewResultsPage;
import com.pl.britenet.util.MovieFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

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

    public Credits getCreditsByMovieId(Integer movieId){
        return movieFinder.getCredits(movieId);
    }

    public ReviewResultsPage getReviewsByMovieId(Integer movieId) {
        return  movieFinder.getReviews(movieId);
    }
}
