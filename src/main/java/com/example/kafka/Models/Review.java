package com.example.kafka.Models;

public class Review {
    public int id;
    public User user;
    public Film film;
    public String text;
    public int rate;

    public Review(int id, User user, Film film, String text, int rate){
        this.id = id;
        this.user = user;
        this.film = film;
        this.text = text;
        this.rate = rate;
    }
}
