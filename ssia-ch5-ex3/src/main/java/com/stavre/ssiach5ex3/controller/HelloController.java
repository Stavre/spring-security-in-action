package com.stavre.ssiach5ex3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, String> getGreeting() {
        return Map.of("en", "hello", "ro", "salut", "fr", "bonjour");
    }
}
