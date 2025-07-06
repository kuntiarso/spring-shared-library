package com.developer.superuser.shared.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shared")
@Data
public class SharedConfigProperties {
    private DateTime dateTime;

    @Data
    public static class DateTime {
        private String zone;
        private String format;
    }
}