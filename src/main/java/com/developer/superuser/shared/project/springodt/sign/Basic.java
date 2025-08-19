package com.developer.superuser.shared.project.springodt.sign;

import com.developer.superuser.shared.helper.Generator;
import com.developer.superuser.shared.utility.Dates;
import com.developer.superuser.shared.utility.Hashes;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
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
        precheck(sign);
        String signature = Hashes.withRsaSha(build(sign), privateKey, algorithm);
        return sign.toBuilder().setSignature(signature).build();
    }

    private void precheck(Sign sign) {
        Preconditions.checkNotNull(sign, "sign must not be null");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(sign.getClientId()), "clientId must not be null or empty");
        Preconditions.checkNotNull(sign.getTimestamp(), "timestamp must not be null");
    }

    private String build(Sign sign) {
        return sign.getClientId() + "|" + Dates.toInstantString(sign.getTimestamp());
    }
}