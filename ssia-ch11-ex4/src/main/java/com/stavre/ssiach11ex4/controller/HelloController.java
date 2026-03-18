package com.stavre.ssiach11ex4.controller;

import com.stavre.ssiach11ex4.dto.Document;
import com.stavre.ssiach11ex4.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HelloController {

    private final DocumentService service;

    @GetMapping("/documents/{code}")
    public Document getDocument(@PathVariable String code) {
        return service.getDocument(code);
    }
}
