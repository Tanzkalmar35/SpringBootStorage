package com.example.SpringBootStorage.services;

import com.example.SpringBootStorage.entities.StorageDataEntry;
import com.example.SpringBootStorage.exceptions.StorageDataNotFoundException;
import com.example.SpringBootStorage.repositories.StorageDataRepository;

import java.util.List;
import java.util.Optional;

public class StorageDataService {

    private StorageDataRepository storageDataRepository;

    public StorageDataService(StorageDataRepository storageDataRepository) {
        this.storageDataRepository = storageDataRepository;
    }

    public Optional<StorageDataEntry> findByName(String name) {
        return storageDataRepository.findByName(name);
    }

    public List<StorageDataEntry> findAllOfUser() {
        return storageDataRepository.findAll();
    }

    public StorageDataEntry saveStorageDataEntry(StorageDataEntry storageDataEntry) {
        return storageDataRepository.save(storageDataEntry);
    }

    public StorageDataEntry updateStorageDataEntry(StorageDataEntry storageDataEntry) {
        return storageDataRepository.save(storageDataEntry);
    }

    public void deleteStorageDataEntry(String name) {
        StorageDataEntry entity = storageDataRepository.findByName(name).orElseThrow(
                () -> new StorageDataNotFoundException("StorageDataEntry with name %s not found.", name)
        );
        storageDataRepository.delete(entity);
    }

}
