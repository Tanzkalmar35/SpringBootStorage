package com.example.SpringBootStorage.repositories;

import com.example.SpringBootStorage.entities.Role;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    @Cacheable("allRoles")
    List<Role> findAll();

    Optional<Role> findByName(final String name);

    @Query("SELECT r FROM Role r JOIN r.users u WHERE u.uuid = :userId")
    Set<Role> findRolesByUser(@Param("userId") final UUID userId);

    @Query("SELECT r FROM Role r WHERE r.uuid in :ids")
    Set<Role> findRolesById(@Param("ids") final List<UUID> ids);

    @Query("SELECT r FROM Role r WHERE r.name in :roleNames")
    Set<Role> findRolesByName(@Param("roleNames") final Set<Role.RoleName> roleNames);
}
