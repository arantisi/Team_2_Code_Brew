package com.security.practice.controllers;

import com.security.practice.models.Watchlist;
import com.security.practice.services.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {
    @Autowired
    private WatchlistService watchlistService;

    @GetMapping("/user/{userId}")
    public List<Watchlist> getWatchListByUserId(@PathVariable int userId) {
        return watchlistService.getWatchlistByUserId(userId);
    }

    @GetMapping("/name/{name}")
    public List<Watchlist> getWatchListByName(@PathVariable String name) {
        return watchlistService.getWatchlistByName(name);
    }

    @GetMapping("/user/{userId}/name/{name}")
    public List<Watchlist> getWatchListByUserIdAndName(@PathVariable int userId,@PathVariable String name) {
        return watchlistService.getWatchlistByUserIdAndName(userId,name);
    }

    @GetMapping("")
    public List<Watchlist> getAllWatchlists() {
        return watchlistService.getAllWatchlists();
    }

    @PostMapping("/user/{userId}/name/{name}/movie/{movieId}/public/{isPublic}")
    public void postSaveWatchlist(@PathVariable String name,@PathVariable int userId,@PathVariable String movieId,@PathVariable Boolean isPublic) {
        watchlistService.postSaveWatchlist(new Watchlist(name,userId,movieId,isPublic));
    }

    @DeleteMapping("/user/{userId}/movie/{movieId}")
    public void deleteWatchListByUserIdAndMovieId(@PathVariable int userId,@PathVariable String movieId) {
        watchlistService.deleteWatchlistByUserIdAndMovieId(userId,movieId);
    }
}