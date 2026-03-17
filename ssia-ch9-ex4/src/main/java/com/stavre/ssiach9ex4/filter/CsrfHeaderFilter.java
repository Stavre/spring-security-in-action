package com.stavre.ssiach9ex4.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

public class CsrfHeaderFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        CsrfToken t = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if (t != null) {
            response.setHeader("X-CSRF-TOKEN", t.getToken());
        }

        filterChain.doFilter(request, response);
    }
}
