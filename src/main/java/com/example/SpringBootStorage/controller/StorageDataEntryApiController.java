package com.example.SpringBootStorage.controller;

import com.example.SpringBootStorage.dto.StorageDataEntryDto;
import com.example.SpringBootStorage.entities.Role;
import com.example.SpringBootStorage.mapper.StorageDataEntryMapper;
import com.example.SpringBootStorage.repositories.StorageDataRepository;
import com.example.SpringBootStorage.services.StorageDataService;
import org.hibernate.annotations.QueryCacheLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/storage")
public class StorageDataEntryApiController {

    @Autowired
    @Lazy
    private StorageDataService storageDataService;

    @Autowired
    @Lazy
    private StorageDataRepository storageDataRepository;

    @PostMapping(consumes = {"application/json"})
    public void createStorageDataEntry(@RequestBody StorageDataEntryDto storageDataEntryDto) {
        storageDataService.saveStorageDataEntry(storageDataEntryDto);
    }

    @GetMapping("/all")
    public List<StorageDataEntryDto> getAllStorageDataEntries() {
        return storageDataRepository.findAll().stream().map(StorageDataEntryMapper::map).collect(Collectors.toList());
    }

    @GetMapping("/{rolename}")
    public Set<StorageDataEntryDto> getStorageDataEntry(@PathVariable("rolename") Role.RoleName rolename) {
        return storageDataService.findAllOfRole(rolename);
    }

    @GetMapping("/names/{rolename}")
    public Set<String> getNamesOfStorageDataEntriesByRole(@PathVariable("rolename") Role.RoleName rolename) {
        return storageDataRepository.findNamesOfRoleData(rolename);
    }
}
