package com.developer.superuser.shared.helper.impl;

import com.developer.superuser.shared.property.SharedConfigProperties;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
public class InstantSerializer extends JsonSerializer<Instant> {
    public final SharedConfigProperties sharedConfig;

    @Override
    public void serialize(Instant value, JsonGenerator gen, SerializerProvider serializer) throws IOException {
        String instantString = DateTimeFormatter
                .ofPattern(sharedConfig.getDateTime().getFormat())
                .withZone(ZoneId.of(sharedConfig.getDateTime().getZone()))
                .format(value);
        gen.writeString(instantString);
    }
}