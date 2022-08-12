package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.services.OMDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/omdb")
public class OMDBController {
    @Autowired
    private OMDBService omdbService;

    @GetMapping("/searchName/{movieTitle}")
    public List<Movie> searchForMovieTitle(@PathVariable String movieTitle) {
        return omdbService.getMoviesByTitle(movieTitle);
    }

    @GetMapping("/searchId/{movieId}")
    public Movie searchForMovieId(@PathVariable String movieId) {
        return omdbService.getMovieById(movieId);
    }
}
