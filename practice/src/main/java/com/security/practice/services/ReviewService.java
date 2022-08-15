package com.security.practice.services;

import com.security.practice.models.Review;
import com.security.practice.repos.ReviewRepository;
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
}