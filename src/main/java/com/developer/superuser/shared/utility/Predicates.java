package com.developer.superuser.shared.utility;

import com.developer.superuser.shared.data.ResponseData;
import lombok.experimental.UtilityClass;

import java.util.function.Predicate;

@UtilityClass
public class Predicates {
    public final Predicate<ResponseData<?>> isSuccessful2xxResponse = response -> response.getCode().startsWith("2");
}