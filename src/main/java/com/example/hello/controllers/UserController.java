package com.example.hello.controllers;

import com.example.hello.models.User;
import com.example.hello.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "saved...";
    }

    @PutMapping("update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) {
        User updatedUser = userRepo.findById(id).get();

        updatedUser.setUsername(user.getUsername());
        updatedUser.setAge(user.getAge());
        userRepo.save(updatedUser);
        return "updated...";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        User deletedUser = userRepo.findById(id).get();
        userRepo.delete(deletedUser);
        return "deleted..." + id;
    }
}
