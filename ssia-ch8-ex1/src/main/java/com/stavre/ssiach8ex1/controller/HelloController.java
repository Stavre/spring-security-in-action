package com.stavre.ssiach8ex1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, String> getHello() {
        return Map.of("greeting", "hello");
    }

    @GetMapping("/ciao")
    public Map<String, String> getCiao() {
        return Map.of("greeting", "ciao");
    }

    @GetMapping("/hola")
    public Map<String, String> getHola() {
        return Map.of("greeting", "ciao");
    }
}
