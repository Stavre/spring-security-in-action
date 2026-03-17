package com.stavre.ssiach9ex3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

@Configuration
public class SecurityFilterChainConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {

        RegexRequestMatcher r = new RegexRequestMatcher("/tsch.?", HttpMethod.POST.name());

        http.csrf(c -> {
            c.ignoringRequestMatchers("/ciao");
            c.ignoringRequestMatchers(r);
        });

        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

        return http.build();
    }
}
