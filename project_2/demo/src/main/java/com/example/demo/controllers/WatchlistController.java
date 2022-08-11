package com.example.demo.controllers;

import com.example.demo.models.Watchlist;
import com.example.demo.services.WatchlistService;
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

    @DeleteMapping("/movie/{movieId}")
    public void deleteWatchListByUserIdAndMovieId(@PathVariable int userId,@PathVariable String movieId) {
         watchlistService.deleteWatchlistByUserIdAndMovieId(userId,movieId);
    }
}