package com.stavre.ssiach12ex4.controller;

import com.stavre.ssiach12ex4.entity.Product;
import com.stavre.ssiach12ex4.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductRepository repository;

    @GetMapping("/products/{text}")
    public List<Product> find(@PathVariable String text) {

        return repository.findProductByNameContains(text);

    }

    @GetMapping("/products")
    public List<Product> findAll() {

        return repository.findAll();

    }


}
