package com.developer.superuser.shared.helper;

public interface Generator<A, B> {
    B generate(A a);

    default B generate() {
        return generate(null);
    }
}