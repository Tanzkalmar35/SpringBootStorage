package com.example.SpringBootStorage.services;

import com.example.SpringBootStorage.entities.Role;
import com.example.SpringBootStorage.entities.User;
import com.example.SpringBootStorage.exceptions.RoleByIdNotFoundException;
import com.example.SpringBootStorage.json.JsonUser;
import com.example.SpringBootStorage.repositories.RoleRepository;
import com.example.SpringBootStorage.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    @Lazy
    private RoleRepository roleRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public User saveUser(JsonUser jsonUser) {
        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = jsonUser.getUser();
        Set<Role> roles = new HashSet<>();

        user.setPassword(passwordEncoder.encode(jsonUser.getPassword()));
        for (Role jsonRole : jsonUser.getRoles()) {
            Role role = entityManager.createQuery("SELECT r FROM Role r WHERE r.name = :roleName", Role.class)
                    .setParameter("roleName", jsonRole.getName())
                    .getSingleResult();
            roles.add(role);
        }
        user.setRoles(roles);

        return userRepository.save(user);
    }

    public User updateUser(final JsonUser jsonUser) {
        return userRepository.save(jsonUser.getUser());
    }

    public void deleteUser(final String username) {
        User entity = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User with username %s not found.", username))
        );
        userRepository.delete(entity);
    }

    public User assignRole(final String userId, final String roleId) {
        final User user = userRepository.findById(UUID.fromString(userId)).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User with id %s not found", userId))
        );
        final Role role = roleRepository.findById(UUID.fromString(roleId)).orElseThrow(
                () -> new RoleByIdNotFoundException("Role with id %s not found", roleId)
        );

        final Set<Role> currentUserRoles = user.getRoles();
        currentUserRoles.add(role);
        user.setRoles(currentUserRoles);

        return userRepository.save(user);
    }

    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );

        String[] roles = Arrays.stream(user.getRoles().toArray())
                .map(Object::toString)
                .toArray(String[]::new);

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(roles)
                .build();
    }
}
