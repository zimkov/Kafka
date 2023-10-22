package com.example.kafka.Controllers;

import com.example.kafka.Models.Film;
import com.example.kafka.Models.Review;
import com.example.kafka.Models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReviewController {
    public List<Review> arrayList = new ArrayList<Review>();

    @GetMapping("/review/")
    public List<Review> getAllReviews() {
        return arrayList;
    }

    @GetMapping("/review/{id}")
    public Review getReviewById(int id){
        return arrayList.get(id);
    }

    @PostMapping("/review")
    public Review createReview(int id, User user, Film film, String text, int rate) {
        arrayList.add(new Review(id, user, film, text, rate));
        return new Review(id, user, film, text, rate);
    }
}
