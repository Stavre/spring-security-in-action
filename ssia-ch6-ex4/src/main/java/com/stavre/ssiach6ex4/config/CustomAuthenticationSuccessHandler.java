package com.stavre.ssiach6ex4.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        var authorities = authentication.getAuthorities();

        boolean hasReadAuthority = authorities.stream().filter(a -> a.getAuthority().equals("read")).findFirst().isPresent();
        boolean hasWriteAuthority = authorities.stream().filter(a -> a.getAuthority().equals("write")).findFirst().isPresent();

        if (hasReadAuthority) {
            response.sendRedirect("http://localhost:8080/home-read");
        } else if (hasWriteAuthority) {
            response.sendRedirect("/home-write");
        } else {
            response.sendRedirect("/home");
        }
    }
}
