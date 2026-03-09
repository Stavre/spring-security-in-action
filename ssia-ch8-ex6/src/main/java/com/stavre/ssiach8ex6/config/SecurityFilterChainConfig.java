package com.stavre.ssiach8ex6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

@Configuration
public class SecurityFilterChainConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/email/{email:.*(?:.+@.+\\.com)}").permitAll()
                .anyRequest().denyAll());

        return http.build();
    }
}