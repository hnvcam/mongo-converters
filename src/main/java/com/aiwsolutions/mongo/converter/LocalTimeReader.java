package com.aiwsolutions.mongo.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;

/**
 * Created by camhoang on 12/20/15.
 */
public class LocalTimeReader implements Converter<String, LocalTime> {
    public LocalTime convert(String s) {
        return LocalTime.parse(s);
    }
}
