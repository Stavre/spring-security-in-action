package com.stavre.ssiach8ex4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterChainConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/product/{code:^[0-9]*$}").permitAll()
                .anyRequest().denyAll());


        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}