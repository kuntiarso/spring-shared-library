package com.developer.superuser.shared.project.springodt.sign;

import com.developer.superuser.shared.helper.Generator;
import com.developer.superuser.shared.utility.Dates;
import com.developer.superuser.shared.utility.Hashes;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.security.PrivateKey;

@RequiredArgsConstructor
public class Basic implements Generator<Sign, Sign> {
    private final String algorithm;
    private final PrivateKey privateKey;

    @Override
    @SneakyThrows
    public Sign generate(Sign sign) {
        String signature = Hashes.withRsaSha(build(sign), privateKey, algorithm);
        return sign.toBuilder().setSignature(signature).build();
    }

    private String build(Sign sign) {
        return sign.getClientId() + "|" + Dates.toInstantString(sign.getTimestamp());
    }
}