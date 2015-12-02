package com.aiwsolutions.mongo.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

/**
 * Created by choang on 12/2/15.
 */
public class LocalDateTimeWriter implements Converter<LocalDateTime, String> {
    public String convert(LocalDateTime localDateTime) {
        return localDateTime.toString();
    }
}
