package com.pl.britenet;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
public class AppTest 
{

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void gettingMovieFromThDbApi() throws Exception {
        getMovie(11).andExpect(status().isOk());
    }

    @Test
    public void notExistingMovieToGet() throws Exception {
        getMovie(999999999).andExpect(status().isBadRequest());
    }

    @Test
    public void successfulGettingMovieReviews() throws Exception {
        getReviews(11).andExpect(status().isOk());
    }

    @Test
    public void notExistingMovieToGetReviews() throws Exception {
        getReviews(999999999).andExpect(status().isBadRequest());
    }

    @Test
    public void successfulGettingMovieCredits() throws Exception {
        getCredits(11).andExpect(status().isOk());
    }

    @Test
    public void notExistingMovieToGetCredits() throws Exception {
        getCredits(999999999).andExpect(status().isBadRequest());
    }

    private ResultActions getCredits(int movieId) throws Exception {
        return mvc.perform(MockMvcRequestBuilders
                .get("/movies/"+ movieId + "/credits")
                .contentType(MediaType.APPLICATION_JSON));
    }

    private ResultActions getReviews(int movieId) throws Exception {
        return mvc.perform(MockMvcRequestBuilders
                .get("/movies/"+ movieId + "/reviews")
                .contentType(MediaType.APPLICATION_JSON));
    }

    private ResultActions getMovie(int movieId) throws Exception {
        return mvc.perform(MockMvcRequestBuilders
                .get("/movies/"+ movieId)
                .contentType(MediaType.APPLICATION_JSON));
    }
}
