package com.example.SpringBootStorage.dto;

import com.example.SpringBootStorage.entities.Role;
import com.example.SpringBootStorage.entities.User;

import java.util.Set;
import java.util.UUID;

public class RoleDto {

    private UUID uuid;

    private Role.RoleName name;

    private Set<User> users;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(final UUID uuid) {
        this.uuid = uuid;
    }

    public Role.RoleName getName() {
        return name;
    }

    public void setName(final Role.RoleName name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(final Set<User> users) {
        this.users = users;
    }
}
