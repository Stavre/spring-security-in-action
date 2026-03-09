package com.stavre.ssiach7ex1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import static com.stavre.ssiach7ex1.config.Authorities.READ;
import static com.stavre.ssiach7ex1.config.Authorities.WRITE;

@Component
public class SecurityFilterChainConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {

        http.formLogin(Customizer.withDefaults());

        http.authorizeHttpRequests(auth -> auth.anyRequest().hasAnyAuthority(WRITE.name(), READ.name()));

        return http.build();
    }
}
