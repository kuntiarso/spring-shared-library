package com.developer.superuser.shared.helper;

public interface Executor<A, B> {
    B execute(A a);

    default B execute() {
        return execute(null);
    }
}