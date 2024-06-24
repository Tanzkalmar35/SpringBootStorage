package com.example.SpringBootStorage.json;

import com.example.SpringBootStorage.entities.Role;
import com.example.SpringBootStorage.entities.User;

import java.util.Set;
import java.util.UUID;

public class JsonUser {

    private UUID uuid;

    private String username;

    private String password;

    private Set<Role> roles;

    public JsonUser(final UUID uuid, final String username, final String password, final Set<Role> roles) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

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

    public User getUser() {
        return new User(this.uuid, this.username, this.password, this.roles);
    }
}
