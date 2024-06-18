package com.example.SpringBootStorage.services;

import com.example.SpringBootStorage.entities.StorageDataEntry;

import java.util.Optional;

public interface StorageDataService {

    Optional<StorageDataEntry> findByName(final String name);

    StorageDataEntry saveStorageDataEntry(final StorageDataEntry storageDataEntry);

    StorageDataEntry updateStorageDataEntry(final StorageDataEntry storageDataEntry);

    void deleteStorageDataEntry(final String name);

}
