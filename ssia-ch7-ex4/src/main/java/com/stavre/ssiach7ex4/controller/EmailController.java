package com.stavre.ssiach7ex4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmailController {

    @GetMapping("/email/{address}.com")
    public Map<String, String> getEmail(@PathVariable String address) {
        return Map.of("email", address + ".com");
    }
}
