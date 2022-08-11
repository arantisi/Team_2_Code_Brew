package com.example.demo.controllers;

import com.example.demo.models.Watchlist;
import com.example.demo.services.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {
    @Autowired
    private WatchlistService watchlistService;

    @GetMapping("/user/{userId}")
    public List<Watchlist> getWatchListByUserId(@PathVariable int userId) {
        return watchlistService.getWatchlistByUser(userId);
    }

    @GetMapping
    public List<Watchlist> getAllWatchlists() {
        return watchlistService.getAllWatchlists();
    }
}