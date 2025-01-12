package com.personal.taskflow.controller;

import com.personal.taskflow.entity.User;
import com.personal.taskflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return  userService.getAllUsers().stream().filter(user -> user.getAge() > 30).toList();
    }
}
