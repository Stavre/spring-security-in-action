package com.stavre.ssiach12ex3.controller;

import com.stavre.ssiach12ex3.dto.Product;
import com.stavre.ssiach12ex3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;


    @GetMapping("/find")
    public List<Product> find() {

        return productService.findProducts();

    }
}
