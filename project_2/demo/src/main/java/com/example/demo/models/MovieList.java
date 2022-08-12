package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class MovieList {
    @JsonProperty("Search")
    private List<Movie> Search;
    public MovieList() {
        this.Search = new ArrayList<>();
    }

    public List<Movie> getList() {
        return Search;
    }

    public void setList(List<Movie> list) {
        this.Search = list;
    }

    public void addMovie(Movie m) {
        Search.add(m);
    }
}
