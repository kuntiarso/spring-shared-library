package com.developer.superuser.shared.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class StandardAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("System");
    }
}