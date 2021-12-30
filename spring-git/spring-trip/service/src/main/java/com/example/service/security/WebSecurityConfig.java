package com.example.service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()//
                .antMatchers("/auth").permitAll()
                .antMatchers("/auth/login").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/auth/insert-user-db").hasAnyAuthority("ADMIN")
                .antMatchers("/auth/insert-trip-db").hasAnyAuthority("ADMIN")
                .antMatchers("/auth/insert-flight-db").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/auth/status-trip").hasAnyAuthority("ADMIN")
                .antMatchers("/auth/update-db").hasAnyAuthority("ADMIN")
                .antMatchers("/auth/delete-db").hasAnyAuthority("ADMIN")
                .antMatchers("/h2-console/**/**").permitAll()
                .antMatchers("/auth/logout").hasAnyAuthority("ADMIN", "USER")
                .anyRequest().authenticated();

        http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/public")
                .and()
                .ignoring()
                .antMatchers("/h2-console/**/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
