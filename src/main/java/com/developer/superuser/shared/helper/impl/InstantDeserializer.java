package com.developer.superuser.shared.helper.impl;

import com.developer.superuser.shared.property.SharedConfigProperties;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
public class InstantDeserializer extends JsonDeserializer<Instant> {
    private final SharedConfigProperties sharedConfig;

    @Override
    public Instant deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern(sharedConfig.getDateTime().getFormat())
                .withZone(ZoneId.of(sharedConfig.getDateTime().getZone()));
        return ZonedDateTime.parse(jsonParser.getText(), formatter).toInstant();
    }
}