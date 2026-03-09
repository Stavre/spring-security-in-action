package com.stavre.ssiach5ex1.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class AuthenticationLoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String requestId = request.getHeader("Request-Id");

        log.info("Request authenticated with request-id %s".formatted(requestId));

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
