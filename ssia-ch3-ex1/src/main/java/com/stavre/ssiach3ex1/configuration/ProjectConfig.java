package com.stavre.ssiach3ex1.configuration;

import com.stavre.ssiach3ex1.service.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> users = List.of(new User("john", "123", "read"));

        return new InMemoryUserDetailsService(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
