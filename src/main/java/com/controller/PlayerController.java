package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playerapi")
public class PlayerController {
    
    @GetMapping("/")
    public String hello() {
        return "Hello from SpringBoot";
    }
}
