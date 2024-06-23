package com.example.SpringBootStorage.services;

import com.example.SpringBootStorage.entities.Role;
import com.example.SpringBootStorage.entities.User;
import com.example.SpringBootStorage.exceptions.RoleByIdNotFoundException;
import com.example.SpringBootStorage.repositories.RoleRepository;
import com.example.SpringBootStorage.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    @Lazy
    private RoleRepository roleRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(final User user) {
        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        final String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public User updateUser(final User user) {
        return userRepository.save(user);
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
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("ADMIN")
                .build();
    }
}
