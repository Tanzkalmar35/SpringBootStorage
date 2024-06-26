package com.example.SpringBootStorage.services;

import com.example.SpringBootStorage.entities.Role;
import com.example.SpringBootStorage.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findRoleById(final UUID roleId) {
        return roleRepository.findById(roleId);
    }
}
