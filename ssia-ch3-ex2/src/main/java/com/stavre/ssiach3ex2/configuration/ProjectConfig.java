package com.stavre.ssiach3ex2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ProjectConfig {

    @Bean
    public UserDetailsManager userDetailsService(DataSource dataSource) {
        String usersByUsernameQuery = "select username, password, enabled from users where username = ?";
        String authsByUserQuery = "select username, authority from authorities where username = ?";

        var useDetailsService = new JdbcUserDetailsManager(dataSource);
        useDetailsService.setUsersByUsernameQuery(usersByUsernameQuery);
        useDetailsService.setAuthoritiesByUsernameQuery(authsByUserQuery);

        return useDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
