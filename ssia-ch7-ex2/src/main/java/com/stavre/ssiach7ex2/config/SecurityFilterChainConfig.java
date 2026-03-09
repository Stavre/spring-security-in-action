package com.stavre.ssiach7ex2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

@Configuration
public class SecurityFilterChainConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {

        String expression = "hasAuthority('read') and !hasAuthority('delete')";

        http.httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests(auth ->
                auth
                        .anyRequest()
                        .access(new WebExpressionAuthorizationManager(expression)));

        return http.build();
    }
}
