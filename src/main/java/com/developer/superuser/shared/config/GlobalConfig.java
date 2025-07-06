package com.developer.superuser.shared.config;

import com.developer.superuser.shared.property.SharedConfigProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.developer.superuser")
@EnableConfigurationProperties(SharedConfigProperties.class)
public class GlobalConfig {
}