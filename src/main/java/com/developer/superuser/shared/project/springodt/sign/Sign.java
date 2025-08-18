package com.developer.superuser.shared.project.springodt.sign;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true, setterPrefix = "set")
@EqualsAndHashCode
@ToString
public class Sign {
    private String requestId;
    private String httpMethod;
    private String endpoint;
    private String token;
    private String digest;
    private String signature;
    private Instant timestamp;
}