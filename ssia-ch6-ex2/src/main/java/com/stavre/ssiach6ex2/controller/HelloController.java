package com.stavre.ssiach6ex2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/authenticated-user-1")
    public Map<String, String> getAuthenticatedUserSecurityContext() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        String username = authentication.getName();
        String password = authentication.getCredentials() == null ? "null": authentication.getCredentials().toString();
        String authorities = authentication.getAuthorities().toString();

        return Map.of("username", username, "password", password, "authorities", authorities, "type", "authentication from SecurityContext");
    }

    @GetMapping("/authenticated-user-2")
    public Map<String, String> getAuthenticatedUserInjectMethodParam(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials() == null ? "null": authentication.getCredentials().toString();
        String authorities = authentication.getAuthorities().toString();

        return Map.of("username", username, "password", password, "authorities", authorities, "type", "authentication injected in method param");
    }
}
