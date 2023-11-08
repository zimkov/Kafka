package com.example.kafka.Controllers;

import com.example.kafka.Models.Review;
import com.example.kafka.repos.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReviewController {
    @Autowired
    private ReviewRepo reviewRepo;

    @GetMapping("/review")
    public Iterable<Review> getAllReviews() {
        Iterable<Review> reviews = reviewRepo.findAll();
        return reviews;
    }

    @GetMapping("/review/{id}")
    public Review getReviewById(int id){
        Review review = null;
        Iterable<Review> reviews = reviewRepo.findAll();
        for (Review x: reviews) {
            if (x.getId() == id) review = x;
        }
        return review;
    }

    @PostMapping("/review")
    public Review createReview(@RequestParam int user, @RequestParam int film, @RequestParam String text, @RequestParam int rate) {
        Review review = new Review(user, film, text, rate);
        reviewRepo.save(review);
        return review;
    }
}
