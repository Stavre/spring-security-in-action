package com.stavre.ssiach11ex6.controller;

import com.stavre.ssiach11ex6.dto.Document;
import com.stavre.ssiach11ex6.service.DocumentService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class HelloController {

    private final DocumentService service;

    @Secured("role_admin")
    @GetMapping("/documents/{code}")
    public Document getDocument(@PathVariable String code) {
        return service.getDocument(code);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/documents/create")
    public void createDocument(@RequestBody String id, Authentication authentication) {
        String owner =  authentication.getName();
        Document doc = new Document(owner);

        service.uploadDocument(id, doc);

    }
}
