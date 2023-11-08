package com.example.kafka.Controllers;

import com.example.kafka.Models.Film;
import com.example.kafka.Models.Review;
import com.example.kafka.Models.User;
import com.example.kafka.repos.FilmRepo;
import com.example.kafka.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmController {
    @Autowired
    private FilmRepo filmRepo;

    @GetMapping("/films")
    public Iterable<Film> getAllFilms() {
        Iterable<Film> films = filmRepo.findAll();
        return films;
    }

    @GetMapping("/films/{id}")
    public Film getFilmById(@RequestParam int id){
        Film film = null;
        Iterable<Film> films = filmRepo.findAll();
        for (Film x: films) {
            if (x.getId() == id) film = x;
        }
        return film;
    }

    @PostMapping("/films")
    public Film createFilm(@RequestParam String name, @RequestParam String director, @RequestParam int year) {
        Film film = new Film(name, director, year);
        filmRepo.save(film);
        return film;
    }
}
