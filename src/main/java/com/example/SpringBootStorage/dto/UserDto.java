package com.example.SpringBootStorage.dto;

import com.example.SpringBootStorage.entities.Role;

import java.util.Set;
import java.util.UUID;

public class UserDto {

    private UUID uuid;

    private String username;

    private String password;

    private Set<Role> roles;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(final UUID uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(final Set<Role> roles) {
        this.roles = roles;
    }
}
