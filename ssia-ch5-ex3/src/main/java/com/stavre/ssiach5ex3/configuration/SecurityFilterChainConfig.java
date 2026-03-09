package com.stavre.ssiach5ex3.configuration;

import com.stavre.ssiach5ex3.filter.LogOnceFilter;
import com.stavre.ssiach5ex3.filter.StaticKeyAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityFilterChainConfig {

    private final LogOnceFilter logOnceFilter;
    private final StaticKeyAuthFilter staticKeyAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {

        http.addFilterBefore(staticKeyAuthFilter, BasicAuthenticationFilter.class);
        http.addFilterAfter(logOnceFilter, BasicAuthenticationFilter.class);

        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

        return http.build();
    }
}
