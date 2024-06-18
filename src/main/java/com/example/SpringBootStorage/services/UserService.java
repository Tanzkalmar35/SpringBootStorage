package com.example.SpringBootStorage.services;

import com.example.SpringBootStorage.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Optional<User> findByUsername(final String username);

    User saveUser(final User user);

    User updateUser(final User user);

    void deleteUser(final String username);
}
