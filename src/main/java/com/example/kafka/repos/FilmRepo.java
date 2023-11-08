package com.example.kafka.repos;

import com.example.kafka.Models.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepo extends CrudRepository<Film, Long> {
}
