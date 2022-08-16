package com.security.practice.controllers;

import com.security.practice.models.CustomUserDetails;
import com.security.practice.models.Favorite;
import com.security.practice.services.FavoriteService;
import com.security.practice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public List<Favorite> getUserFavorites(@PathVariable int userId) {
        return favoriteService.getFavoritesByUser(userId);
    }


    @GetMapping()
    public String favoriteView() {
        return "favorite";
    }

    /*@GetMapping("/user")
    public String getUserFavorites(Model model, Authentication authentication) {
        System.out.println("hello, getUserFavorites");
        model.addAttribute("anything", "this is coming from the FavoriteController");

        String username = authentication.getName();
        int userId = userService.getUserByUsername(username).getId();
        List<Favorite> favorites =  favoriteService.getFavoritesByUser(userId);
        model.addAttribute("favoriteList", favorites);
        return "favorite";
    }*/

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
