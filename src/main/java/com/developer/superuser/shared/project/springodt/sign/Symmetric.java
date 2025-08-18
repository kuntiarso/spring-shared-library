package com.developer.superuser.shared.project.springodt.sign;

import com.developer.superuser.shared.helper.Generator;
import com.developer.superuser.shared.utility.Dates;
import com.developer.superuser.shared.utility.Hashes;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.time.Instant;

@RequiredArgsConstructor
public class Symmetric implements Generator<String, String> {
    private final String algorithm;
    private final String apiKey;

    @Override
    @SneakyThrows
    public String generate(String payload) {
        String[] args = payload.split("\\|");
        precheck(args);
        return Hashes.withHmacSha(build(args), apiKey, algorithm);
    }

    public String generate(String httpMethod, String endpoint, String token, String digest) {
        return generate(httpMethod + "|" + endpoint + "|" + token + "|" + digest);
    }

    private void precheck(String... args) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(args[1]), "httpMethod must not be null or empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(args[2]), "endpoint must not be null or empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(args[3]), "token must not be null or empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(args[4]), "digest must not be null or empty");
    }

    private String build(String... args) {
        return args[1] + ":" + args[2] + ":" + args[3] + ":" + args[4] + ":" + Dates.toInstantString(Instant.now());
    }
}