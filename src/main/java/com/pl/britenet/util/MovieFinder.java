package com.pl.britenet.util;

import com.pl.britenet.model.Credits;
import com.pl.britenet.model.Movie;
import com.pl.britenet.model.ReviewResultsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieFinder {

    private static final String API_KEY = "41d5caf2cf4818f824e186c538684689";

    private static RestTemplate restTemplate;

    @Autowired
    public MovieFinder(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static Movie getById(Integer movieId) {
        Movie movie = restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/" + movieId
                        + "?api_key=" + API_KEY + "&language=en-US", Movie.class);
        return movie;
    }

    public static Credits getCredits(Integer movieId) {
        Credits credits = restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/" + movieId + "/credits?api_key=" + API_KEY,
                Credits.class);
        return credits;
    }

    public ReviewResultsPage getReviews(Integer movieId) {
        ReviewResultsPage reviews = restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/" +
                        movieId +
                        "/reviews?api_key="
                        + API_KEY
                        + "&language=en-US&page=1",
                ReviewResultsPage.class);
        return reviews;
    }
}
