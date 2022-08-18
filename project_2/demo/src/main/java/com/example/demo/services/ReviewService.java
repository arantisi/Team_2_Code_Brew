package com.example.demo.services;

import com.example.demo.models.Review;
import com.example.demo.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> getReviewsByUser(int userId) {
        return reviewRepository.findByUserId(userId);
    }

    public void deleteFromReviews(int userId, String movieId) {
        reviewRepository.deleteByUserIdAndMovieId(userId, movieId);
    }

    public void createReview(Review review) {
        reviewRepository.save(review);
    }

//    public void editRating(int userId, String movieId, int rating) {
//        reviewRepository.updateRating(userId, movieId, rating);
//    }
//
//    public void editReview(int userId, String movieId, String review) {
//        reviewRepository.updateReview(userId, movieId, review);
//    }
}