package com.developer.superuser.shared.helper;

public interface Builder<A, B> {
    B build(A a);

    default B build() {
        return build(null);
    }
}