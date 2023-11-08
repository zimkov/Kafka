package com.example.kafka.repos;

import com.example.kafka.Models.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepo extends CrudRepository<Review, Long> {
}
