package com.example.SpringBootStorage.controller;

import com.example.SpringBootStorage.entities.StorageDataEntry;
import com.example.SpringBootStorage.exceptions.StorageDataNotFoundException;
import com.example.SpringBootStorage.repositories.StorageDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    @Lazy
    private StorageDataRepository storageDataRepository;

    @GetMapping("/new")
    public String home() {
        return "newstorage";
    }

    @GetMapping("/edit")
    public String edit() {
        return "editstorage";
    }

    @GetMapping("/{storageDataName}")
    public String dataByName(@PathVariable("storageDataName") final String dataName, final Model model) {
        final StorageDataEntry storageDataEntry = storageDataRepository.findByName(dataName).orElseThrow(
                () -> new StorageDataNotFoundException("Storage data name %s not found!", dataName)
        );
        model.addAttribute("dataName", storageDataEntry.getName());
        model.addAttribute("dataProperties", storageDataEntry.getProperties());
        model.addAttribute("dataRoles", storageDataEntry.getRolesWithPermission());
        return "storageentry";
    }
}
