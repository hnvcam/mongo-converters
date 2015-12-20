package com.aiwsolutions.mongo.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

/**
 * Created by camhoang on 12/20/15.
 */
public class LocalDateReader implements Converter<String, LocalDate> {
    public LocalDate convert(String s) {
        return LocalDate.parse(s);
    }
}
