package com.example.SpringBootStorage.repositories;

import com.example.SpringBootStorage.entities.StorageDataEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StorageDataRepository extends JpaRepository<StorageDataEntry, UUID> {

    Optional<StorageDataEntry> findByName(final String name);

}
