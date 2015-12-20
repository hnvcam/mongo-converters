package com.aiwsolutions.mongo.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;

/**
 * Created by camhoang on 12/20/15.
 */
public class LocalTimeWriter implements Converter<LocalTime, String> {
    public String convert(LocalTime localTime) {
        return localTime.toString();
    }
}
