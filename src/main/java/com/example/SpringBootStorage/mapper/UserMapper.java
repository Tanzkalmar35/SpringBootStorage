package com.example.SpringBootStorage.mapper;

import com.example.SpringBootStorage.entities.User;
import com.example.SpringBootStorage.dto.UserDto;

/**
 * A mapper between UserDto and User to separate the core business logic from the frontend logic.
 */
public class UserMapper {

    /**
     * Maps a UserDto to a User object.
     *
     * @param userDto is mapped to a User object.
     * @return a new User object with the data of the UserDto.
     */
    public static User map(final UserDto userDto) {
        User user = new User();

        user.setUuid(userDto.getUuid());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRoles(userDto.getRoles());

        return user;
    }
}
