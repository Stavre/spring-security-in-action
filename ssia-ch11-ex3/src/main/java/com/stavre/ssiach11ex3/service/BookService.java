package com.stavre.ssiach11ex3.service;

import com.stavre.ssiach11ex3.dto.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {


    private final Employee emma = new Employee("Emma Thompson",
            List.of("Karamazov Brothers"),
            List.of("accountant", "reader"));

    private final Employee natalie = new Employee("Natalie Parker",
            List.of("Beautiful Paris"),
            List.of("researcher"));


    private final Map<String, Employee> records =
            Map.of(
                    "natalie", natalie,
                    "emma", emma
            );

    @PostAuthorize("returnObject.roles.contains('reader')")
    public Employee getBookDetails(String name) {
        return records.get(name);
    }
}
