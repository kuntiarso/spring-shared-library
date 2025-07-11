package com.developer.superuser.shared.config;

import com.developer.superuser.shared.audit.StandardAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.developer.superuser.shared", includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Repository$"))
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "standardAuditorAware")
public class JpaConfig {
    @Bean
    public AuditorAware<String> standardAuditorAware() {
        return new StandardAuditorAware();
    }
}