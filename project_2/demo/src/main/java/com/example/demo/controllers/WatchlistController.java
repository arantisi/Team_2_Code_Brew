package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.models.Watchlist;
import com.example.demo.services.UserService;
import com.example.demo.services.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;


import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {
    @Autowired
    private WatchlistService watchlistService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public List<Watchlist> getWatchListByUserId(@PathVariable int userId) {
        return watchlistService.getWatchlistByUserId(userId);
    }

    /**
     * Don't need Path Variable. Get user id from authentication.
     * @param authentication Authentication is imported from Spring Security
     * @return
     */
    @GetMapping("/user")
    public List<Watchlist> getWatchListByUserId(Authentication authentication) {
        String username = authentication.getName();
        int userId = userService.getUserByUsername(username).getId();
        return watchlistService.getWatchlistByUserId(userId);
    }


    @GetMapping
    public List<Watchlist> getAllWatchlists() {
        return watchlistService.getAllWatchlists();
    }
}
