package com.developer.superuser.shared.utility;

import com.developer.superuser.shared.openapi.contract.ErrorData;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Errors {
    public ErrorData ok() {
        return ok("Success");
    }

    public ErrorData ok(String message) {
        return ok("200", message);
    }

    public ErrorData ok(String code, String message) {
        return ErrorData.builder()
                .setStatus(200)
                .setResponseCode(code)
                .setResponseMessage(message)
                .build();
    }

    public ErrorData badRequest() {
        return badRequest("Bad request");
    }

    public ErrorData badRequest(String message) {
        return badRequest("400", message);
    }

    public ErrorData badRequest(String code, String message) {
        return ErrorData.builder()
                .setStatus(400)
                .setResponseCode(code)
                .setResponseMessage(message)
                .build();
    }

    public ErrorData internalServerError() {
        return internalServerError("Internal server error");
    }

    public ErrorData internalServerError(String message) {
        return internalServerError("500", message);
    }

    public ErrorData internalServerError(String code, String message) {
        return ErrorData.builder()
                .setStatus(500)
                .setResponseCode(code)
                .setResponseMessage(message)
                .build();
    }

    public ErrorData error(Integer status) {
        return error(status, "Unknown server error");
    }

    public ErrorData error(Integer status, String message) {
        return error(status, String.valueOf(status), message);
    }

    public ErrorData error(Integer status, String code, String message) {
        return ErrorData.builder()
                .setStatus(status)
                .setResponseCode(code)
                .setResponseMessage(message)
                .build();
    }
}