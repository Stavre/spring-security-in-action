package com.stavre.ssiach11ex2.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NameService {

    private final Map<String, List<String>> secretNames =
            Map.of(
                    "natalie", List.of("Energetico", "Perfecto"),
                    "emma", List.of("Factastico")
            );

    @PreAuthorize("#name == authentication.principal.username")
    public List<String> getSecretNames(String name) {
        return secretNames.get(name);
    }
}
