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
public class FilmController {
    public List<Film> arrayList = new ArrayList<Film>();

    @GetMapping("/films/")
    public List<Film> getAllFilms() {
        return arrayList;
    }

    @GetMapping("/films/{id}")
    public Film getFilmById(int id){
        return arrayList.get(id);
    }

    @PostMapping("/films")
    public Film createFilm(int id, String name, String director, int year) {
        arrayList.add(new Film(id, name, director, year));
        return new Film(id, name, director, year);
    }
}
