package com.example.journal.global.config;

import com.example.journal.global.error.ExceptionHandler;
import com.example.journal.global.security.jwt.JwtTokenFilter;
import com.example.journal.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final ObjectMapper objectMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void configure(HttpSecurity builder){
        ExceptionHandler exceptionHandler = new ExceptionHandler(objectMapper);
        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtTokenProvider);
        builder.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        builder.addFilterBefore(exceptionHandler, JwtTokenFilter.class);
    }
}
