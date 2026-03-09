package com.stavre.ssiach2ex4.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final CustomAuthenticationProvider customAuthenticationProvider;

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());

        http.authenticationProvider(customAuthenticationProvider);

        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        return http.build();
    }
}
