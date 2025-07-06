package com.developer.superuser.shared.component;

import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringContext {
    @Getter
    private static ApplicationContext context;

    public SpringContext(ApplicationContext context) {
        SpringContext.context = context;
    }
}