package com.stavre.ssiach11ex1.controller;

import com.stavre.ssiach11ex1.service.NameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HelloController {

    private final NameService nameService;

    @GetMapping("/hello")
    public String hello() {
        return "hello, %s".formatted(nameService.getName());
    }
}
