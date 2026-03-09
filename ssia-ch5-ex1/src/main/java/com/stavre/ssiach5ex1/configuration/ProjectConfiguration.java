package com.stavre.ssiach5ex1.configuration;

import com.stavre.ssiach5ex1.filter.AuthenticationLoggingFilter;
import com.stavre.ssiach5ex1.filter.RequestValidationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class ProjectConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class);
        http.addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class);
        http.authorizeHttpRequests(authRequests -> authRequests.anyRequest().permitAll());

        return http.build();
    }
}
