package com.stavre.ssiach8ex4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/product/{code}")
    public String getProductByCode(@PathVariable String code) {
        return code;
    }
}
