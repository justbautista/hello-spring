package com.example.hello.api.controllers;

import com.example.hello.api.models.User;
import com.example.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user")
    public User getUser(@RequestParam Integer id) {
        Optional user = userService.getUser(id);

        if (user.isPresent()) {
            return (User) user.get();
        }

        return null;
    }
}
