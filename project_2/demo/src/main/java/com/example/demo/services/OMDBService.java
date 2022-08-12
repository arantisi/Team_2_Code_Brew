package com.example.demo.services;

import com.example.demo.models.Movie;
import com.example.demo.models.MovieList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OMDBService {
    private RestTemplate restTemplate;

    public OMDBService() {}

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> getMoviesByTitle(String movieTitle) {
        String url = "https://www.omdbapi.com/?apikey=12b87e4f&s=" + movieTitle;
        MovieList resp = restTemplate.getForObject(url, MovieList.class);

        if (resp == null)
            return new ArrayList<>();

        //debugging
        //for (Movie m : resp.getList())
        //    System.out.println(m.getTitle());

        return resp.getList();
    }

    public Movie getMovieById(String movieId) {
        String url = "https://www.omdbapi.com/?apikey=12b87e4f&i=" + movieId;
        Movie resp = restTemplate.getForObject(url, Movie.class);

        if (resp == null)
            return null;

        System.out.println(resp);
        return resp;
    }
}
