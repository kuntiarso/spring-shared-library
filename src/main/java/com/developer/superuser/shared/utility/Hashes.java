package com.developer.superuser.shared.utility;

import lombok.experimental.UtilityClass;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

@UtilityClass
public class Hashes {
    public String withHmacSha(String input, String secret, String algorithm) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] secretBytes = secret.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec signingKey = new SecretKeySpec(secretBytes, 0, secretBytes.length, algorithm);
        Mac hmacSha = Mac.getInstance(algorithm);
        hmacSha.init(signingKey);
        byte[] signatureBytes = hmacSha.doFinal(input.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(signatureBytes);
    }

    public String withRsaSha(String input, PrivateKey privateKey, String algorithm) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signingKey = Signature.getInstance(algorithm);
        signingKey.initSign(privateKey);
        signingKey.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] signatureBytes = signingKey.sign();
        return Base64.getEncoder().encodeToString(signatureBytes);
    }
}