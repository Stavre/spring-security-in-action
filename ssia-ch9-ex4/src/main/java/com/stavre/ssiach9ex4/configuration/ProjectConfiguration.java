package com.stavre.ssiach9ex4.configuration;

import com.stavre.ssiach9ex4.filter.CsrfHeaderFilter;
import com.stavre.ssiach9ex4.repository.CustomCsrfTokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.h2.util.json.JSONTextSource;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.*;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.security.web.session.DisableEncodeUrlFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@Slf4j
public class ProjectConfiguration {

    private final CustomCsrfTokenRepository csrfTokenRepository;

    public ProjectConfiguration(CustomCsrfTokenRepository csrfTokenRepository) {
        this.csrfTokenRepository = csrfTokenRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        log.info("security chain");
        log.info(csrfTokenRepository.toString());

        http.csrf(c -> {
            c.csrfTokenRepository(csrfTokenRepository);
            c.csrfTokenRequestHandler(new XorCsrfTokenRequestAttributeHandler());
        });
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

        http.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);

        return http.build();
    }
}

