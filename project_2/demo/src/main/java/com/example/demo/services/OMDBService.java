package com.example.demo.services;

import com.example.demo.models.Movie;
import com.example.demo.models.MovieList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OMDBService {
    private RestTemplate restTemplate;

    @Value("${OMDB_api_key}")
    private String api_key;

    public OMDBService() {}

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> getMoviesByTitle(String movieTitle) {
        String url = "https://www.omdbapi.com/?apikey="+api_key+"&s=" + movieTitle;
        MovieList resp = restTemplate.getForObject(url, MovieList.class);

        if (resp == null) // No movies found
            return new ArrayList<>();

        // debugging
        //for (Movie m : resp.getList())
        //    System.out.println(m.getTitle());

        return resp.getList();
    }

    public List<Movie> getMoviesByTitle(String movieTitle, int page) {
        if (page < 1 || page > 100) // Invalid page
            return new ArrayList<>();

        String url = "https://www.omdbapi.com/?apikey="+api_key+"&s=" + movieTitle + "&page=" + page;
        MovieList resp = restTemplate.getForObject(url, MovieList.class);

        if (resp == null) // No movies found
            return new ArrayList<>();

        // debugging
        //for (Movie m : resp.getList())
        //    System.out.println(m.getTitle());

        return resp.getList();
    }

    public Movie getMovieById(String movieId) {
        String url = "https://www.omdbapi.com/?apikey="+api_key+"&i=" + movieId;
        Movie resp = restTemplate.getForObject(url, Movie.class);

        if (resp == null)
            return null;

        // debugging
        //System.out.println(resp);

        return resp;
    }
}
