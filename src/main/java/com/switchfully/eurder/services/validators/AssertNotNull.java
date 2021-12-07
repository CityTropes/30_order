package com.switchfully.eurder.services.validators;

import java.util.Arrays;
import java.util.Objects;

public class AssertNotNull {
    public static void assertAllParamsNotNull(Object... args) {
        if (Arrays.stream(args).allMatch(Objects::isNull)) {
            throw new IllegalArgumentException("No parameter can be null! ");
        }
    }
}
