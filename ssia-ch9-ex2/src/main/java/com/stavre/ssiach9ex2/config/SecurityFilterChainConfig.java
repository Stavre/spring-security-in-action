package com.stavre.ssiach9ex2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterChainConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.formLogin(c -> {
            c.defaultSuccessUrl("/product");
        });

        http.authorizeHttpRequests(auth ->
                auth.anyRequest().authenticated()
        );

        return http.build();
    }
}
