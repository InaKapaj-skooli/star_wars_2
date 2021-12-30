package com.example.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BeanFactory {

    @Bean
    public PasswordEncoder passwordEncoders() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public void authenticationManager() {
       //return super.authenticationManager();
    }
}
