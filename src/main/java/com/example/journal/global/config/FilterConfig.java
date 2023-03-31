package com.example.journal.global.config;

import com.example.journal.global.error.ExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final ObjectMapper objectMapper;

    @Override
    public void configure(HttpSecurity builder){
        ExceptionHandler exceptionHandler = new ExceptionHandler(objectMapper);
    }
}
