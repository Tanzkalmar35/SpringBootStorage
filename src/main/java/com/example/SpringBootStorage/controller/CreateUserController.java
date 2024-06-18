package com.example.SpringBootStorage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateUserController {

    @GetMapping("/create-user")
    public String home() {
        return "createuser";
    }

}
