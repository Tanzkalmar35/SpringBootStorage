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

    public static StorageDataEntryDto map(final StorageDataEntry storageDataEntry) {
        StorageDataEntryDto storageDataEntryDto = new StorageDataEntryDto();

        storageDataEntryDto.setName(storageDataEntry.getName());
        storageDataEntryDto.setRolesWithPermission(storageDataEntry.getRolesWithPermission());
        storageDataEntryDto.setProperties(storageDataEntry.getProperties());

        return storageDataEntryDto;
    }
}
