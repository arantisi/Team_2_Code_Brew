package com.example.demo.controllers;

import com.example.demo.models.Favorite;
import com.example.demo.models.Review;
import com.example.demo.services.ReviewService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @GetMapping("/user/{userId}")
    public List<Review> getUserReviews(@PathVariable int userId) {
        return reviewService.getReviewsByUser(userId);
    }

    @PostMapping("/{userId}/createReview")
    public void createreview(@PathVariable int userId, @RequestBody Review review) {
    }

    @GetMapping("/user")
    public List<Review> getUserReviews(Authentication authentication) {
        String username = authentication.getName();
        int userId = userService.getUserByUsername(username).getId();
        return reviewService.getReviewsByUser(userId);
    }
}
