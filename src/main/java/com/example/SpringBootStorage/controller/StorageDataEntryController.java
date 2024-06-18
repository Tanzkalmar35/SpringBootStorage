package com.example.SpringBootStorage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/storage")
public class StorageDataEntryController {

    @GetMapping
    public String getStorageDataEntry() {
        return "storage";
    }
}
