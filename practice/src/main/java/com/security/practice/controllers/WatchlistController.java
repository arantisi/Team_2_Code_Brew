package com.security.practice.controllers;

import com.security.practice.models.CustomUserDetails;
import com.security.practice.models.Favorite;
import com.security.practice.models.Watchlist;
import com.security.practice.services.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {
    @Autowired
    private WatchlistService watchlistService;

    /*@GetMapping("/user/{userId}")
    public List<Watchlist> getWatchListByUserId(@PathVariable int userId) {
        return watchlistService.getWatchlistByUserId(userId);
    }*/

    @GetMapping("/user")
    public List<Watchlist> getUserWatchlist() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return watchlistService.getWatchlistByUserId(user.getId());
    }

    @GetMapping("/name/{name}")
    public List<Watchlist> getWatchListByName(@PathVariable String name) {
        return watchlistService.getWatchlistByName(name);
    }

    @GetMapping("user/name/{name}")
    public List<Watchlist> getWatchListByNameAndID(@PathVariable String name) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return watchlistService.getWatchlistByUserIdAndName(user.getId(),name);
    }

    /*@GetMapping("/user/{userId}/name/{name}")
    public List<Watchlist> getWatchListByUserIdAndName(@PathVariable int userId,@PathVariable String name) {
        return watchlistService.getWatchlistByUserIdAndName(userId,name);
    }*/

    /*@GetMapping("")
    public List<Watchlist> getAllWatchlists() {
        return watchlistService.getAllWatchlists();
    }*/

    /*@PostMapping("/user/{userId}/name/{name}/movie/{movieId}/public/{isPublic}")
    public void postSaveWatchlist(@PathVariable String name,@PathVariable int userId,@PathVariable String movieId,@PathVariable Boolean isPublic) {
        watchlistService.postSaveWatchlist(new Watchlist(name,userId,movieId,isPublic));
    }*/

    /*@PostMapping("/user/name/{name}/movie/{movieId}/public/{isPublic}")
    public void postSaveWatchlist(@PathVariable String name,@PathVariable int userId,@PathVariable String movieId,@PathVariable Boolean isPublic) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        watchlistService.postSaveWatchlist(new Watchlist(name,user.getId(),movieId,isPublic));
    }*/

    @DeleteMapping("/user/delete/movie/{movieId}")
    public void deleteWatchListByUserIdAndMovieId(@PathVariable int userId,@PathVariable String movieId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        watchlistService.deleteWatchlistByUserIdAndMovieId(user.getId(),movieId);
    }

    @PostMapping("user/create/movie/{movieId}")
    public void addToWatchlist(@PathVariable String movieId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        watchlistService.addToWatchlist(new Watchlist("watchlist",user.getId(), movieId,true));
    }
}