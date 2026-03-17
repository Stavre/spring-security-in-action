package com.stavre.ssiach9ex4.controller;

import com.stavre.ssiach9ex4.entity.Token;
import com.stavre.ssiach9ex4.repository.JpaTokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class HelloController {

    private final JpaTokenRepository tokenRepository;

    @GetMapping("/hello")
    public String getHello() {
        log.info("hello endpoint");

        return "get hello";
    }

    @GetMapping("/hellotoken")
    public List<Token> getHelloToken() {
        return tokenRepository.findAll();
    }

    @PostMapping("/hello")
    public String postHello() {
        return "post hello";
    }
}
