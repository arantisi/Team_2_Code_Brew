package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name="Watchlists")

public class Watchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int userId;
    private String movieId;
    private boolean isPublic;

    public Watchlist() {
    }

    public Watchlist(int id, String name, int userId, String movieId, boolean isPublic) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.movieId = movieId;
        this.isPublic = isPublic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    @Override
    public String toString() {
        return "Watchlists{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                ", movieId='" + movieId + '\'' +
                ", isPublic=" + isPublic +
                '}';
    }
}
