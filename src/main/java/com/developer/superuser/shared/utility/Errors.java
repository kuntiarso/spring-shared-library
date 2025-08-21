package com.developer.superuser.shared.utility;

import com.developer.superuser.shared.openapi.contract.ErrorData;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Errors {
    public ErrorData ok() {
        return ErrorData.builder()
                .setResponseCode("200")
                .setResponseMessage("OK")
                .build();
    }

    public ErrorData badRequest() {
        return ErrorData.builder()
                .setResponseCode("400")
                .setResponseMessage("Bad Request")
                .build();
    }

    public ErrorData internalServerError() {
        return ErrorData.builder()
                .setResponseCode("500")
                .setResponseMessage("Internal Server Error")
                .build();
    }

    public ErrorData error(String code, String message) {
        return ErrorData.builder()
                .setResponseCode(code)
                .setResponseMessage(message)
                .build();
    }
}