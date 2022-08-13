package com.example.demo.controllers;

import com.example.demo.models.Review;
import com.example.demo.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{userId}/createReview")
    public void createreview(@PathVariable int userId, @RequestBody Review review) {

    }
}
