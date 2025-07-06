package com.developer.superuser.shared.utility;

import com.developer.superuser.shared.component.SpringContext;
import com.developer.superuser.shared.property.SharedConfigProperties;
import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class Dates {
    public Instant now() {
        SharedConfigProperties sharedConfig = SpringContext.getContext().getBean(SharedConfigProperties.class);
        ZoneId zoneId = ZoneId.of(sharedConfig.getDateTime().getZone());
        ZonedDateTime zonedDateTime = Instant.now().atZone(zoneId);
        return zonedDateTime.toInstant();
    }

    public String toInstantString(Instant instant) {
        SharedConfigProperties sharedConfig = SpringContext.getContext().getBean(SharedConfigProperties.class);
        ZoneId zoneId = ZoneId.of(sharedConfig.getDateTime().getZone());
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        return zonedDateTime.format(DateTimeFormatter.ofPattern(sharedConfig.getDateTime().getFormat()));
    }
}