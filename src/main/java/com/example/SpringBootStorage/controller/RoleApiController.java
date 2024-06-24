package com.example.SpringBootStorage.controller;

import com.example.SpringBootStorage.entities.Role;
import com.example.SpringBootStorage.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleApiController {

    @Autowired
    @Lazy
    private RoleRepository roleRepository;

    @GetMapping("/all")
    // TODO: Refactor to RoleDto
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

}
