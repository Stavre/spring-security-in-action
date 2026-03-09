package com.stavre.ssiach2ex2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterChainConfig {
    @Bean
    SecurityFilterChain configure(HttpSecurity httpSecurity) {

        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.authorizeHttpRequests(auth ->
                auth.
                        anyRequest().
                        permitAll());
        return httpSecurity.build();
    }
}
