package com.pl.britenet.controller;

import java.util.NoSuchElementException;

import com.pl.britenet.model.BaseResultsPage;
import com.pl.britenet.model.Credits;
import com.pl.britenet.model.Movie;
import com.pl.britenet.model.ReviewResultsPage;
import com.pl.britenet.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;


@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer movieId) {
        Movie movie;
        try {
            movie = movieService.getMovieById(movieId);
        } catch (NoSuchElementException e ) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(movie, HttpStatus.OK);
    }

    @GetMapping("/{movieId}/credits")
    public ResponseEntity<Credits> getCreditsByMOvieId(@PathVariable Integer movieId) {
        Credits credits;
        try {
            credits = movieService.getCreditsByMovieId(movieId);
        } catch (NoSuchElementException e ) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (HttpClientErrorException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(credits, HttpStatus.OK);
    }

    @GetMapping("/{movieId}/reviews")
    public ResponseEntity<ReviewResultsPage> getMovieReview(@PathVariable Integer movieId) {
        BaseResultsPage resultsPage;
        try {
            resultsPage = movieService.getReviewsByMovieId(movieId);
        } catch (NoSuchElementException e ) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (HttpClientErrorException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(resultsPage, HttpStatus.OK);
    }
}
