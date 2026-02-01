package com.example.pws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 1. Disable CSRF protection. Without this, all POST/PUT/DELETE
                // requests will fail with 403 or 401 during testing.
                .csrf(csrf -> csrf.disable())

                // 2. Configure request authorization
                .authorizeHttpRequests(auth -> auth
                        // Permits all requests starting with /api/
                        .requestMatchers("/api/**").permitAll()
                        // Explicitly permits any other request to prevent 401s on other routes
                        .anyRequest().permitAll()
                );

        return httpSecurity.build();
    }
}