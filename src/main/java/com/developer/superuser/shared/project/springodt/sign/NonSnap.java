package com.developer.superuser.shared.project.springodt.sign;

import com.developer.superuser.shared.helper.Generator;
import com.developer.superuser.shared.utility.Dates;
import com.developer.superuser.shared.utility.Hashes;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class NonSnap implements Generator<Sign, Sign> {
    private final String algorithm;
    private final String apiKey;

    private static final String SYMBOL_COLON = ":";
    private static final String SYMBOL_NEW_LINE = "\n";
    private static final String NON_SNAP_REQUEST_ID = "Request-Id";
    private static final String NON_SNAP_CLIENT_ID = "Client-Id";
    private static final String NON_SNAP_TIMESTAMP = "Request-Timestamp";
    private static final String NON_SNAP_ENDPOINT = "Request-Target";
    private static final String NON_SNAP_DIGEST = "Digest";

    @Override
    @SneakyThrows
    public Sign generate(Sign sign) {
        precheck(sign);
        String signature = Hashes.withHmacSha(build(sign), apiKey, algorithm);
        return sign.toBuilder().setSignature(signature).build();
    }

    private void precheck(Sign sign) {
        Preconditions.checkNotNull(sign, "sign must not be null");
        Preconditions.checkState(!Strings.isNullOrEmpty(sign.getClientId()), "clientId must not be null or empty");
        Preconditions.checkState(!Strings.isNullOrEmpty(sign.getRequestId()), "requestId must not be null or empty");
        Preconditions.checkNotNull(sign.getTimestamp(), "timestamp must not be null");
        Preconditions.checkState(!Strings.isNullOrEmpty(sign.getEndpoint()), "endpoint must not be null or empty");
        Preconditions.checkNotNull(sign.getHttpMethod(), "httpMethod must not be null");
        Preconditions.checkState(!Strings.isNullOrEmpty(sign.getDigest()), "digest must not be null or empty");
    }

    private String build(Sign sign) {
        StringBuilder sb = new StringBuilder();
        sb.append(NON_SNAP_CLIENT_ID);
        sb.append(SYMBOL_COLON);
        sb.append(sign.getClientId());
        sb.append(SYMBOL_NEW_LINE);
        sb.append(NON_SNAP_REQUEST_ID);
        sb.append(SYMBOL_COLON);
        sb.append(sign.getRequestId());
        sb.append(SYMBOL_NEW_LINE);
        sb.append(NON_SNAP_TIMESTAMP);
        sb.append(SYMBOL_COLON);
        sb.append(Dates.toInstantString(sign.getTimestamp()));
        sb.append(SYMBOL_NEW_LINE);
        sb.append(NON_SNAP_ENDPOINT);
        sb.append(SYMBOL_COLON);
        sb.append(sign.getEndpoint());
        if ("POST".equalsIgnoreCase(sign.getHttpMethod()) || "PUT".equalsIgnoreCase(sign.getHttpMethod())) {
            sb.append(SYMBOL_NEW_LINE);
            sb.append(NON_SNAP_DIGEST);
            sb.append(SYMBOL_COLON);
            sb.append(sign.getDigest());
        }
        return sb.toString();
    }
}