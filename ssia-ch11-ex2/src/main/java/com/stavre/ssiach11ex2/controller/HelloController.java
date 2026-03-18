package com.stavre.ssiach11ex2.controller;

import com.stavre.ssiach11ex2.service.NameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HelloController {

    private final NameService nameService;

    @GetMapping("/secret/names/{name}")
    public List<String> hello(@PathVariable String name) {
        return nameService.getSecretNames(name);
    }
}
