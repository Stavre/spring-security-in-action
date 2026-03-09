package com.stavre.ssiach6ex4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class CustomUserDetailsService {

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();

        var userRead = User.withUsername("john").password("123").authorities("read").build();
        var userWrite = User.withUsername("sam").password("123").authorities("write").build();
        var userNoAuthority = User.withUsername("jack").password("123").build();

        userDetailsService.createUser(userRead);
        userDetailsService.createUser(userWrite);
        userDetailsService.createUser(userNoAuthority);

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
