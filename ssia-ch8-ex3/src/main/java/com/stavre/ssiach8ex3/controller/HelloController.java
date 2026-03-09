package com.stavre.ssiach8ex3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping("/a")
    public String first() {
        return "Works!";
    }

    @GetMapping("/a")
    public String second() {
        return "Works!";
    }

    @GetMapping("/a/b")
    public String third() {
        return "Works!";
    }

    @GetMapping("/a/b/c")
    public String fourth() {
        return "Works!";
    }
}
