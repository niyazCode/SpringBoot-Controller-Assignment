package com.arch.assingment.util;

import org.springframework.http.MediaType;

public class CustomeMeType extends MediaType {
    public static final String APPLICATION_JSON_V2 = "application/json";
    public CustomeMeType(String type) {
        super(type);
    }
}
