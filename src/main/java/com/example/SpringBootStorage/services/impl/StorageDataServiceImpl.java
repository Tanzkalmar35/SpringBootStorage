package com.example.SpringBootStorage.services.impl;

import com.example.SpringBootStorage.entities.StorageDataEntry;
import com.example.SpringBootStorage.exceptions.StorageDataNotFoundException;
import com.example.SpringBootStorage.repositories.StorageDataRepository;
import com.example.SpringBootStorage.services.StorageDataService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StorageDataServiceImpl implements StorageDataService {

    final StorageDataRepository storageDataRepository;

    public StorageDataServiceImpl(StorageDataRepository storageDataRepository) {
        this.storageDataRepository = storageDataRepository;
    }

    @Override
    public Optional<StorageDataEntry> findByName(String name) {
        return storageDataRepository.findByName(name);
    }

    @Override
    public StorageDataEntry saveStorageDataEntry(StorageDataEntry storageDataEntry) {
        return storageDataRepository.save(storageDataEntry);
    }

    @Override
    public StorageDataEntry updateStorageDataEntry(StorageDataEntry storageDataEntry) {
        return storageDataRepository.save(storageDataEntry);
    }

    @Override
    public void deleteStorageDataEntry(String name) {
        StorageDataEntry entity = storageDataRepository.findByName(name).orElseThrow(
                () -> new StorageDataNotFoundException(String.format("StorageDataEntry with name %s not found.", name))
        );
        storageDataRepository.delete(entity);
    }
}
