package com.example.kafka.Controllers;

import com.example.kafka.Models.User;
import com.example.kafka.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        Iterable<User> users = userRepo.findAll();

        return users;
    }

    @GetMapping("/users/{id}")
    public User getUserById(@RequestParam int id){
        User getUser = null;
        Iterable<User> users = userRepo.findAll();
        for (User x: users) {
            if (x.getId() == id) getUser = x;
        }
        return getUser;
    }

    @PostMapping("/users")
    public User createUser(@RequestParam String firstName, @RequestParam  String lastName, @RequestParam int age) {
        User user = new User(firstName,lastName, age);
        userRepo.save(user);

        return user;
    }
}
