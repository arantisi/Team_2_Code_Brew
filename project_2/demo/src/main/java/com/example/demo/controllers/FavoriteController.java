package com.example.demo.controllers;

import com.example.demo.models.CustomUserDetails;
import com.example.demo.models.Favorite;
import com.example.demo.services.FavoriteService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<Favorite> getUserFavorites(@PathVariable int userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return favoriteService.getFavoritesByUser(user.getId());
    }


    @GetMapping()
    public String favoriteView() {
        return "favorite";
    }


    @GetMapping("/user")
    public List<Favorite> getUserFavorites() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return favoriteService.getFavoritesByUser(user.getId());
    }

    // add a movie to favorites
    @PostMapping("/user/{userId}/movie/{movieId}")
    public void addToFavorites(@PathVariable int userId, @PathVariable String movieId) {
        favoriteService.addToFavorites(new Favorite(userId, movieId));
    }

    @PostMapping("/movie/{movieId}")
    public void addToFavorites(@PathVariable String movieId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        favoriteService.addToFavorites(new Favorite(user.getId(), movieId));
    }

    // delete a movie from favorites
    @DeleteMapping("/user/{userId}/movie/{movieId}")
    public void deleteFromFavorites(@PathVariable int userId, @PathVariable String movieId) {
        favoriteService.deleteFromFavorites(userId, movieId);
    }

}