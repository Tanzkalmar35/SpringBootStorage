package com.example.SpringBootStorage.controller;

import com.example.SpringBootStorage.entities.User;
import com.example.SpringBootStorage.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public Optional<User> findUser(@PathVariable("username") final String username) {
        return userService.findByUsername(username);
    }

    @PostMapping(consumes = {"application/json"})
    public User saveUser(@RequestBody final User user) {
        return userService.saveUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody final User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable("username") final String username) {
        userService.deleteUser(username);
    }
}
