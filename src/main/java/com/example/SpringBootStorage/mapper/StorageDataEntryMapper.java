package com.example.SpringBootStorage.mapper;

import com.example.SpringBootStorage.dto.StorageDataEntryDto;
import com.example.SpringBootStorage.entities.StorageDataEntry;

public class StorageDataEntryMapper {

    public static StorageDataEntry map(final StorageDataEntryDto storageDataEntryDto) {
        StorageDataEntry storageDataEntry = new StorageDataEntry();

        storageDataEntry.setName(storageDataEntryDto.getName());
        storageDataEntry.setRolesWithPermission(storageDataEntryDto.getRolesWithPermission());
        storageDataEntry.setProperties(storageDataEntryDto.getProperties());

        return storageDataEntry;
    }

}
