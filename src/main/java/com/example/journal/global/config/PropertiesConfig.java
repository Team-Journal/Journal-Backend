package com.example.journal.global.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationPropertiesScan(basePackages = "com.example.journal")
@Configuration
public class PropertiesConfig {
}
