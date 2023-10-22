package com.example.kafka.Models;

public class Film {
    public int id;
    public String name;
    public String director;
    public int year;

    public Film(int id, String name, String director, int year){
        this.id = id;
        this.name = name;
        this.director = director;
        this.year = year;
    }
}
