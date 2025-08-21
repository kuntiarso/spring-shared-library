package com.developer.superuser.shared.utility;

import com.developer.superuser.shared.openapi.contract.ErrorData;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Errors {
    public ErrorData ok() {
        return ok("Success");
    }

    public ErrorData ok(String message) {
        return ErrorData.builder()
                .setResponseCode("200")
                .setResponseMessage(message)
                .build();
    }

    public ErrorData badRequest() {
        return badRequest("Bad request");
    }

    public ErrorData badRequest(String message) {
        return ErrorData.builder()
                .setResponseCode("400")
                .setResponseMessage(message)
                .build();
    }

    public ErrorData internalServerError() {
        return internalServerError("Internal server error");
    }

    public ErrorData internalServerError(String message) {
        return ErrorData.builder()
                .setResponseCode("500")
                .setResponseMessage(message)
                .build();
    }

    public ErrorData error(String code) {
        return error(code, "Unknown server error");
    }

    public ErrorData error(String code, String message) {
        return ErrorData.builder()
                .setResponseCode(code)
                .setResponseMessage(message)
                .build();
    }
}