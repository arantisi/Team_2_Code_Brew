package com.example.demo.controllers;

import com.example.demo.models.Favorite;
import com.example.demo.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    FavoriteService favoriteService;

    @GetMapping("/user/{userId}")
    public List<Favorite> getUserFavorites(@PathVariable int userId) {
        return favoriteService.getFavoritesByUser(userId);
    }
}