package com.developer.superuser.shared.data;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, setterPrefix = "set")
@EqualsAndHashCode
@ToString(callSuper = true)
public class ResponseData<A> {
    private String code;
    private String message;
    private String timestamp;
    private A body;

    public static <A> ResponseData<A> success() {
        return success(null);
    }

    public static <A> ResponseData<A> success(A body) {
        return new ResponseData<>("SUCCESS", "Successful", Instant.now().toString(), body);
    }

    public static <A> ResponseData<A> error(String code, String message) {
        return error(code, message, null);
    }

    public static <A> ResponseData<A> error(String code, String message, A body) {
        return new ResponseData<>(code, message, Instant.now().toString(), body);
    }
}