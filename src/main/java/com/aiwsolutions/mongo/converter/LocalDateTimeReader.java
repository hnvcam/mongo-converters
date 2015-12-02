package com.aiwsolutions.mongo.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

/**
 * Created by choang on 12/2/15.
 */
public class LocalDateTimeReader implements Converter<String, LocalDateTime> {
    public LocalDateTime convert(String s) {
        return LocalDateTime.parse(s);
    }
}
