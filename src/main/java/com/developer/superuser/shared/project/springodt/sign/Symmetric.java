package com.developer.superuser.shared.project.springodt.sign;

import com.developer.superuser.shared.helper.Generator;
import com.developer.superuser.shared.utility.Dates;
import com.developer.superuser.shared.utility.Hashes;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Symmetric implements Generator<Sign, Sign> {
    private final String algorithm;
    private final String apiKey;

    @Override
    @SneakyThrows
    public Sign generate(Sign sign) {
        precheck(sign);
        String signature = Hashes.withHmacSha(build(sign), apiKey, algorithm);
        return sign.toBuilder().setSignature(signature).build();
    }

    private void precheck(Sign sign) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(sign.getHttpMethod()), "httpMethod must not be null or empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(sign.getEndpoint()), "endpoint must not be null or empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(sign.getToken()), "token must not be null or empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(sign.getDigest()), "digest must not be null or empty");
    }

    private String build(Sign sign) {
        return sign.getHttpMethod()
                + ":"
                + sign.getEndpoint()
                + ":"
                + sign.getToken()
                + ":"
                + sign.getDigest()
                + ":"
                + Dates.toInstantString(sign.getTimestamp());
    }
}