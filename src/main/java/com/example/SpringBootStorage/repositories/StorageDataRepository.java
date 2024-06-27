package com.example.SpringBootStorage.repositories;

import com.example.SpringBootStorage.entities.Role;
import com.example.SpringBootStorage.entities.StorageDataEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface StorageDataRepository extends JpaRepository<StorageDataEntry, UUID> {

    Optional<StorageDataEntry> findByName(final String name);

    @Query("SELECT data FROM StorageDataEntry data JOIN data.rolesWithPermission role WHERE role.name = :roleName")
    Set<StorageDataEntry> findAllOfRole(@Param("roleName") final Role.RoleName roleName);

}
