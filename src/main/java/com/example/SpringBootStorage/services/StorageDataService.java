package com.example.SpringBootStorage.services;

import com.example.SpringBootStorage.dto.StorageDataEntryDto;
import com.example.SpringBootStorage.entities.Role;
import com.example.SpringBootStorage.entities.StorageDataEntry;
import com.example.SpringBootStorage.exceptions.StorageDataNotFoundException;
import com.example.SpringBootStorage.mapper.StorageDataEntryMapper;
import com.example.SpringBootStorage.repositories.RoleRepository;
import com.example.SpringBootStorage.repositories.StorageDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StorageDataService {

    private StorageDataRepository storageDataRepository;

    @Autowired
    @Lazy
    private RoleRepository roleRepository;

    public StorageDataService(final StorageDataRepository storageDataRepository) {
        this.storageDataRepository = storageDataRepository;
    }

    public Optional<StorageDataEntry> findByName(final String name) {
        return storageDataRepository.findByName(name);
    }

    @Transactional
    public Set<StorageDataEntryDto> findAllOfRole(final Role.RoleName roleName) {
        final Set<StorageDataEntry> dataOfRole = storageDataRepository.findAllOfRole(roleName);
        final Set<StorageDataEntryDto> dataOfRoleDto =
                dataOfRole.stream().map(StorageDataEntryMapper::map).collect(Collectors.toSet());
        return dataOfRoleDto;
    }

    public Set<String> getNamesOfRoleData(final Role.RoleName roleName) {
        return storageDataRepository.findNamesOfRoleData(roleName);
    }

    @Transactional
    public StorageDataEntry saveStorageDataEntry(final StorageDataEntryDto storageDataEntryDto) {
        final StorageDataEntry storageDataEntry = StorageDataEntryMapper.map(storageDataEntryDto);

        storageDataEntry.getProperties().forEach(property -> property.setStorageDataEntry(storageDataEntry));

        Set<Role.RoleName> namesOfRolesWithPermission =
                storageDataEntry.getRolesWithPermission().stream().map(Role::getName).collect(Collectors.toSet());
        Set<Role> rolesWithPermission = roleRepository.findRolesByName(namesOfRolesWithPermission);
        storageDataEntry.setRolesWithPermission(rolesWithPermission);

        return storageDataRepository.save(storageDataEntry);
    }

    public StorageDataEntry updateStorageDataEntry(final StorageDataEntry storageDataEntry) {
        return storageDataRepository.save(storageDataEntry);
    }

    public void deleteStorageDataEntry(final String name) {
        StorageDataEntry entity = storageDataRepository.findByName(name).orElseThrow(
                () -> new StorageDataNotFoundException("StorageDataEntry with name %s not found.", name)
        );
        storageDataRepository.delete(entity);
    }

}
