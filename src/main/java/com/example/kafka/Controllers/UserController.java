package com.example.kafka.Controllers;

import com.example.kafka.Models.User;
import com.example.kafka.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        Iterable<User> users = userRepo.findAll();

        return users;
    }

//    @GetMapping("/users/{id}")
//    public User getUserById(int id){
//        return userRepo.get(id);
//    }

    @PostMapping("/users")
    public User createUser(@RequestParam String firstName, @RequestParam  String lastName, @RequestParam int age) {
        User user = new User(firstName,lastName, age);
        userRepo.save(user);

        return new User(firstName, lastName, age);
    }
}
