package com.stavre.ssiach8ex6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @GetMapping("/email/{email}")
    public String getVideo(@PathVariable String email) {
        return "Email sent to %s!".formatted(email);
    }

}
