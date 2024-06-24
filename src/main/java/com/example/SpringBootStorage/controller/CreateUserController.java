package com.example.SpringBootStorage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class CreateUserController {

    @GetMapping("/new")
    public String home() {
        return "createuser";
    }

}
