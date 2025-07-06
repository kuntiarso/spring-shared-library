package com.developer.superuser.shared.helper.impl;

import com.developer.superuser.shared.helper.Formatter;
import com.developer.superuser.shared.helper.Generator;
import com.developer.superuser.shared.property.SharedConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class InstantHelper implements Generator<Void, Instant>, Formatter<Instant, String> {
    private final SharedConfigProperties sharedConfig;

    @Override
    public Instant generate(Void unused) {
        ZoneId zoneId = ZoneId.of(sharedConfig.getDateTime().getZone());
        ZonedDateTime zonedDateTime = Instant.now().atZone(zoneId);
        return zonedDateTime.toInstant();
    }

    @Override
    public String format(Instant instant) {
        ZoneId zoneId = ZoneId.of(sharedConfig.getDateTime().getZone());
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        return zonedDateTime.format(DateTimeFormatter.ofPattern(sharedConfig.getDateTime().getFormat()));
    }
}