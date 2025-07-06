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
    public Instant getInstantNow() {
        SharedConfigProperties sharedConfig = SpringContext.getContext().getBean(SharedConfigProperties.class);
        ZoneId asiaJakartaZone = ZoneId.of(sharedConfig.getDateTime().getZone());
        ZonedDateTime currentDateTime = Instant.now().atZone(asiaJakartaZone);
        return currentDateTime.toInstant();
    }

    public String instantToString(Instant dateTime) {
        SharedConfigProperties sharedConfig = SpringContext.getContext().getBean(SharedConfigProperties.class);
        ZoneId asiaJakartaZone = ZoneId.of(sharedConfig.getDateTime().getZone());
        ZonedDateTime zonedDateTime = dateTime.atZone(asiaJakartaZone);
        return zonedDateTime.format(DateTimeFormatter.ofPattern(sharedConfig.getDateTime().getFormat()));
    }
}