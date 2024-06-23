package com.example.SpringBootStorage.controller;

import com.example.SpringBootStorage.entities.Role;
import com.example.SpringBootStorage.entities.User;
import com.example.SpringBootStorage.repositories.RoleRepository;
import com.example.SpringBootStorage.repositories.UserRepository;
import com.example.SpringBootStorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

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

    @PutMapping("/{userId}/{roleId}")
    public User assignRole(
            @PathVariable("roleId") final String roleId,
            @PathVariable("userId") final String userId) {

        return userService.assignRole(userId, roleId);
    }
}
