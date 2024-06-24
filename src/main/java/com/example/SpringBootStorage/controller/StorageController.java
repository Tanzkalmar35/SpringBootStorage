package com.example.SpringBootStorage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/storage")
public class StorageController {

    @GetMapping("/new")
    public String home() {
        return "newstorage";
    }

    @GetMapping("/edit")
    public String edit() {
        return "editstorage";
    }
}
