package com.example.demo.controllers;

import com.example.demo.models.Favorite;
import com.example.demo.services.FavoriteService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;


import java.util.List;

//@RestController
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

//    @GetMapping("/user")
//    public List<Favorite> getUserFavorites(Model model, Authentication authentication) {
//        model.addAttribute("something", "this is coming from the FavoriteController");
//
//        String username = authentication.getName();
//        int userId = userService.getUserByUsername(username).getId();
//        return favoriteService.getFavoritesByUser(userId);
//    }
    @GetMapping()
    public String favoriteView() {
        return "favorite";
    }

    @GetMapping("/user")
    public String getUserFavorites(Model model, Authentication authentication) {
        System.out.println("hello, getUserFavorites");
        model.addAttribute("anything", "this is coming from the FavoriteController");

        String username = authentication.getName();
        int userId = userService.getUserByUsername(username).getId();
        List<Favorite> favorites =  favoriteService.getFavoritesByUser(userId);
        model.addAttribute("favoriteList", favorites);
        return "favorite";
    }
}








