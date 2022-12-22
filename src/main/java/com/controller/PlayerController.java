package com.controller;

import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playerapi")
public class PlayerController {
    
    @GetMapping("/")
    public String hello() {
        String output = "Hello from SpringBoot";
        output += "<br>Spring version: " + SpringVersion.getVersion();
        output += "<br>Java version: "+System.getProperty("java.version");
        return output;
    }
}
