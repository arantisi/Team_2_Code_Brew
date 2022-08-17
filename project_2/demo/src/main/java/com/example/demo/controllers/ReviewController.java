package com.example.demo.controllers;

import com.example.demo.models.CustomUserDetails;
import com.example.demo.models.Favorite;
import com.example.demo.models.Review;
import com.example.demo.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

//    @GetMapping("/user/{userId}")
//    public List<Review> getUserReviews(@PathVariable int userId) {
//        return reviewService.getReviewsByUser(userId);
//    }

    @GetMapping("/user")
    public List<Review> getUserReviews() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return reviewService.getReviewsByUser(user.getId());
    }

    // create a review
    // Not sure if 2 @Requestbody will work. Uncomment out the next createReview method if you think it would work.
    @PostMapping("/create/{movieId}")
    public void createReview(@RequestBody String review, @RequestBody int rating, @PathVariable String movieId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        reviewService.createReview(new Review(user.getId(), movieId, rating, review));
    }

    // Pass in a review w/o userId. You can add the movieId to the review in the front-end and remove {movieId} from this URI
//    @PostMapping("/create/{movieId}")
//    public void createReview(@RequestBody Review review, @PathVariable String movieId) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
//        review.setUserId(user.getId());
//        reviewService.createReview(review);
//    }

    //     Creates a Review with a default rating of 1
    @PostMapping("/create/review/{movieId}")
    public void createReviewWithDefaultRating(@RequestBody String review, @PathVariable String movieId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        reviewService.createReview(new Review(user.getId(), movieId, 1, review));
    }

    @PutMapping("/editRating/{movieId}")
    public void editRating(@RequestBody int rating, @PathVariable String movieId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        reviewService.editRating(user.getId(), movieId, rating);
    }

    @PutMapping("/editReview/{movieId}")
    public void editReview(@RequestBody String review, @PathVariable String movieId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        reviewService.editReview(user.getId(), movieId, review);
    }


    @DeleteMapping("/delete/{movieId}")
    public void deleteFromReviews(@PathVariable String movieId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        reviewService.deleteFromReviews(user.getId(), movieId);
    }

}