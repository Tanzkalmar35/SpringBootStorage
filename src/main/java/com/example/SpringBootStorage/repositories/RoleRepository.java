package com.example.SpringBootStorage.repositories;

import com.example.SpringBootStorage.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findByName(final String name);

    @Query("SELECT r FROM Role r JOIN r.users u WHERE u.uuid = :userId")
    Set<Role> findRolesByUser(final UUID userId);
}
