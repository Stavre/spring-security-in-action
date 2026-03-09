package com.stavre.ssiach9ex2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class ProductController {

    @GetMapping("/product")
    public String getMainPage() {
        return "product.html";
    }

    @PostMapping("/product/add")
    public String add(@RequestParam String name) {
        log.info("Adding product: " + name);
        return "product.html";
    }
}
