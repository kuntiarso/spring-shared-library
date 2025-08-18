package com.developer.superuser.shared.project.springodt.sign;

import com.developer.superuser.shared.helper.Generator;
import com.developer.superuser.shared.utility.Dates;
import com.developer.superuser.shared.utility.Hashes;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.security.PrivateKey;
import java.time.Instant;

@RequiredArgsConstructor
public class Basic implements Generator<Void, String> {
    private final String clientId;
    private final String algorithm;
    private final PrivateKey privateKey;

    @Override
    @SneakyThrows
    public String generate(Void unused) {
        return Hashes.withRsaSha(build(), privateKey, algorithm);
    }

    private String build() {
        return clientId + "|" + Dates.toInstantString(Instant.now());
    }
}