package com.example.SpringBootStorage.services;

import com.example.SpringBootStorage.entities.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);
}
