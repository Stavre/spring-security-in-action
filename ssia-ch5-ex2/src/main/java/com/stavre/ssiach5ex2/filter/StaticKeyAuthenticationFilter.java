package com.stavre.ssiach5ex2.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class StaticKeyAuthenticationFilter implements Filter {

    @Value("${authorization.key}")
    private String staticRequestId;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String requestId = httpServletRequest.getHeader("Request-Id");

        boolean isRequestIdValid = staticRequestId.equals(requestId);

        if (isRequestIdValid) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
