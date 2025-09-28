package com.developer.superuser.shared.project.springodt.helper;

import com.developer.superuser.shared.helper.Generator;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@RequiredArgsConstructor
public class Digest implements Generator<String, String> {
    public final String algorithm;

    @Override
    @SneakyThrows
    public String generate(String request) {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(request.getBytes(StandardCharsets.UTF_8));
        return toHexLowerCase(md.digest());
    }

    private static String toHexLowerCase(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}