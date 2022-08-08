package com.example.demo.models;

public class Ratings {

    private int ratingsId;
    private String username;
    private int rating;
    private String movieTitle;

    public Ratings() {
    }

    public Ratings(int ratingsId, String username, int rating, String movieTitle) {
        this.ratingsId = ratingsId;
        this.username = username;
        this.rating = rating;
        this.movieTitle = movieTitle;
    }

    public int getRatingsId() {
        return ratingsId;
    }

    public void setRatingsId(int ratingsId) {
        this.ratingsId = ratingsId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "ratingsId=" + ratingsId +
                ", username='" + username + '\'' +
                ", rating=" + rating +
                ", movieTitle='" + movieTitle + '\'' +
                '}';
    }
}
