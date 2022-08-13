package com.example.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="pass")
    private String password;

    // this code may be unnecessary
    // maybe use a Set instead of a List
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = Watchlist.class, cascade = CascadeType.ALL)
//    private List<Watchlist> watchlists;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="userId", referencedColumnName="id")
    private List<Watchlist> watchlists = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="userId", referencedColumnName="id")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="userId", referencedColumnName="id")
    private List<Favorite> favorites = new ArrayList<>();


//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = Favorite.class, cascade = CascadeType.ALL)
//    private List<Favorite> favoriteList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = Review.class, cascade = CascadeType.ALL)
//    private List<Review> reviewList;

    public User() {}

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, List<Watchlist> watchlists, List<Review> reviews, List<Favorite> favorites) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.watchlists = watchlists;
        this.reviews = reviews;
        this.favorites = favorites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public List<Watchlist> getWatchlists() {
        return watchlists;
    }

    public void setWatchlists(List<Watchlist> watchlists) {
        this.watchlists = watchlists;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }
}