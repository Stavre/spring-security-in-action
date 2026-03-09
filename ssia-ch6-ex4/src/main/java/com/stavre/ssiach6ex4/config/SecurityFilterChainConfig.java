package com.stavre.ssiach6ex4.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityFilterChainConfig {

    private final CustomAuthenticationSuccessHandler authenticationSuccessHandler;
    private final CustomAuthenticationFailureHandler authenticationFailureHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.formLogin(c -> {
            c.successHandler(authenticationSuccessHandler);
            c.failureHandler(authenticationFailureHandler);
        });

        http.httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests(auth ->
                auth.requestMatchers("/auth-failure").permitAll().anyRequest().authenticated());

        return http.build();
    }
}
