package com.switchfully.eurder.services.validators;

import java.util.regex.Pattern;

public class RegexPattern {
    public static final Pattern emailPattern = Pattern.compile("^(.+)@(.+)\\.(.+)$");
}
