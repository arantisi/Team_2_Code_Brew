package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name="Reviews")

public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String movieId;
    private int rating;
    private String review;

    public Reviews() {
    }

    public Reviews(int id, int userId, String movieId, int rating, String review) {
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id=" + id +
                ", userId=" + userId +
                ", movieId='" + movieId + '\'' +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}
