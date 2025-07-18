package com.developer.superuser.shared.helper.impl;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDeserializer extends JsonDeserializer<BigDecimal> {
    @Override
    public BigDecimal deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException {
        String text = parser.getText().trim();
        try {
            BigDecimal value = new BigDecimal(text);
            BigDecimal scaledValue = value.setScale(2, RoundingMode.HALF_UP);
            if (scaledValue.precision() > 19) {
                throw new IllegalArgumentException("BigDecimal precision exceeds 19 digits: " + scaledValue);
            }
            return scaledValue;
        } catch (NumberFormatException ex) {
            throw new JsonParseException(parser, "Invalid BigDecimal value: " + text);
        }
    }
}