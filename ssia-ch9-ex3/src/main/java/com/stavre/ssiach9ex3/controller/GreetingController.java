package com.stavre.ssiach9ex3.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GreetingController {

    @PostMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/ciao")
    public String ciao() {
        return "ciao";
    }

    @PostMapping("/tschuss")
    public String tschuss() {
        return "tschuss";
    }
}
