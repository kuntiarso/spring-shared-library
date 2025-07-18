package com.developer.superuser.shared.config;

import com.developer.superuser.shared.helper.impl.BigDecimalDeserializer;
import com.developer.superuser.shared.helper.impl.BigDecimalSerializer;
import com.developer.superuser.shared.helper.impl.InstantDeserializer;
import com.developer.superuser.shared.helper.impl.InstantSerializer;
import com.developer.superuser.shared.property.SharedConfigProperties;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.Instant;

@Configuration
public class JacksonConfig {
    @Bean
    public Module instantModule(SharedConfigProperties sharedConfig) {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Instant.class, new InstantSerializer(sharedConfig));
        module.addDeserializer(Instant.class, new InstantDeserializer(sharedConfig));
        module.addSerializer(BigDecimal.class, new BigDecimalSerializer());
        module.addDeserializer(BigDecimal.class, new BigDecimalDeserializer());
        return module;
    }
}