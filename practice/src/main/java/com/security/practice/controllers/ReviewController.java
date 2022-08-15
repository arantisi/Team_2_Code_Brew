package com.security.practice.controllers;

import com.security.practice.models.Review;
import com.security.practice.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/user/{userId}")
    public List<Review> getUserReviews(@PathVariable int userId) {
        return reviewService.getReviewsByUser(userId);
    }

}