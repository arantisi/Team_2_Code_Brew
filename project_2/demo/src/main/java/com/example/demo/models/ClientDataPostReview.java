package com.example.demo.models;

public class ClientDataPostReview {
    public String rating;
    public String review;
    // you need a zero argument constructor
    ClientDataPostReview (){}

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
    // maybe you have to add getter and setters
}
