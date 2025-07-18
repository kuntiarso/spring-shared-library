package com.developer.superuser.shared.helper.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializer) throws IOException {
        if (value == null) {
            gen.writeNull();
            return;
        }
        BigDecimal scaledValue = value.setScale(2, RoundingMode.HALF_UP);
        if (scaledValue.precision() > 19) {
            throw new IllegalArgumentException("BigDecimal precision exceeds 19 digits: " + scaledValue);
        }
        String formattedValue = scaledValue.toPlainString();
        if (formattedValue.length() > 20) {
            formattedValue = formattedValue.substring(0, 19);
        }
        gen.writeString(formattedValue);
    }
}