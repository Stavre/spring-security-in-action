package com.stavre.ssiach6ex4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home-read")
    public String getHomePageForReadAuthority() {
        return "home-read.html";
    }

    @GetMapping("/home-write")
    public String getHomePageForWriteAuthority() {
        return "home-write.html";
    }

    @GetMapping("/home")
    public String getHomePageForNoAuthority() {
        return "home.html";
    }

    @GetMapping("/auth-failure")
    public String getAuthFailedPage() {
        return "auth-failure.html";
    }
}
