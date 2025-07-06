package com.developer.superuser.shared.helper;

public interface Formatter<A, B> {
    B format(A a);

    default B format() {
        return format(null);
    }
}