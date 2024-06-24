package com.example.SpringBootStorage.services;

import com.example.SpringBootStorage.entities.Role;
import com.example.SpringBootStorage.entities.User;
import com.example.SpringBootStorage.exceptions.RoleByIdNotFoundException;
import com.example.SpringBootStorage.dto.UserDto;
import com.example.SpringBootStorage.repositories.RoleRepository;
import com.example.SpringBootStorage.repositories.UserRepository;
import com.example.SpringBootStorage.mapper.UserMapper;
import jakarta.transaction.Transactional;
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

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public User saveUser(final UserDto userDto) {
        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = UserMapper.map(userDto);

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        final Set<Role.RoleName> userRolesNames = userDto.getRoles().stream().map(Role::getName).collect(Collectors.toSet());
        final Set<Role> userRoles = roleRepository.findRolesByName(userRolesNames);
        user.setRoles(userRoles);

        return userRepository.save(user);
    }

    public User updateUser(final UserDto userDto) {
        return userRepository.save(UserMapper.map(userDto));
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
