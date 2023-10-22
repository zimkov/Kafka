package com.example.kafka.Controllers;

import com.example.kafka.Models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    public List<User> arrayList = new ArrayList<User>();

    @GetMapping("/users/")
    public List<User> getAllUsers() {
        return arrayList;
    }

    @GetMapping("/users/{id}")
    public User getUserById(int id){
        return arrayList.get(id);
    }

    @PostMapping("/users")
    public User createUser(int id, String firstName, String lastName, int age) {
        arrayList.add(new User(id, firstName, lastName, age));
        return new User(id, firstName, lastName, age);
    }
}
