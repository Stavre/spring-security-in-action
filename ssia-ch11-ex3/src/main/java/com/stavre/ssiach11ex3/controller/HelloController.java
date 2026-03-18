package com.stavre.ssiach11ex3.controller;

import com.stavre.ssiach11ex3.dto.Employee;
import com.stavre.ssiach11ex3.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class HelloController {

    private final BookService service;

    @GetMapping("/book/details/{name}")
    public Employee getDetails(@PathVariable String name) {
        return service.getBookDetails(name);
    }
}
