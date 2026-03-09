package com.stavre.ssiach6ex2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        return http.build();
    }
}
