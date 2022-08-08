package com.example.demo.models;

public class Watchlists {

    private int watchlistsId;
    private String watchlistsName;
    private String username;
    private String visibility;
    private String movieTitle;

    public Watchlists() {
    }

    public Watchlists(int watchlistsId, String watchlistsName, String username, String visibility, String movieTitle) {
        this.watchlistsId = watchlistsId;
        this.watchlistsName = watchlistsName;
        this.username = username;
        this.visibility = visibility;
        this.movieTitle = movieTitle;
    }

    public int getWatchlistsId() {
        return watchlistsId;
    }

    public void setWatchlistsId(int watchlistsId) {
        this.watchlistsId = watchlistsId;
    }

    public String getWatchlistsName() {
        return watchlistsName;
    }

    public void setWatchlistsName(String watchlistsName) {
        this.watchlistsName = watchlistsName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public String toString() {
        return "Watchlists{" +
                "watchlistsId=" + watchlistsId +
                ", watchlistsName='" + watchlistsName + '\'' +
                ", username='" + username + '\'' +
                ", visibility='" + visibility + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                '}';
    }
}
