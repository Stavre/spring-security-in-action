package com.stavre.ssiach7ex1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.stavre.ssiach7ex1.config.Authorities.READ;
import static com.stavre.ssiach7ex1.config.Authorities.WRITE;

@Configuration
public class UserDetailsServiceConfiguration {

    @Bean
    public UserDetailsService userDetailsService() {
        var service = new InMemoryUserDetailsManager();

        var readUser = User.withUsername("john").password("123").authorities(READ.name()).build();
        var writeUser = User.withUsername("sam").password("123").authorities(WRITE.name()).build();
        var plainUser = User.withUsername("john").password("123").build();

        service.createUser(readUser);
        service.createUser(writeUser);
        service.createUser(plainUser);

        return service;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
