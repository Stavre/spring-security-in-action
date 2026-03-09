package com.stavre.ssiach5ex3.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class StaticKeyAuthFilter implements Filter {

    @Value("${authentication.key}")
    private String staticKey;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String receivedKey = httpRequest.getHeader("Request-Id");

        boolean isAuthenticated = staticKey.equals(receivedKey);

        if (isAuthenticated) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

    }
}
