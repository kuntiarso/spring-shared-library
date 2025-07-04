package com.developer.superuser.shared.helper;

public interface Validator<A, B> {
    B validate(A a);

    default B validate() {
        return validate(null);
    }
}