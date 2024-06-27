package com.example.SpringBootStorage.controller;

import com.example.SpringBootStorage.dto.StorageDataEntryDto;
import com.example.SpringBootStorage.entities.Role;
import com.example.SpringBootStorage.repositories.StorageDataRepository;
import com.example.SpringBootStorage.services.StorageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/storage")
public class StorageDataEntryApiController {

    @Autowired
    private StorageDataService storageDataService;

    @PostMapping(consumes = {"application/json"})
    public void createStorageDataEntry(@RequestBody StorageDataEntryDto storageDataEntryDto) {
        storageDataService.saveStorageDataEntry(storageDataEntryDto);
    }

    @GetMapping("/{rolename}")
    public Set<StorageDataEntryDto> getStorageDataEntry(@PathVariable("rolename") Role.RoleName rolename) {
        return storageDataService.findAllOfRole(rolename);
    }
}
