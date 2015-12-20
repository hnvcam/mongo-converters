package com.aiwsolutions.mongo.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

/**
 * Created by camhoang on 12/20/15.
 */
public class LocalDateWriter implements Converter<LocalDate, String> {
    public String convert(LocalDate localDate) {
        return localDate.toString();
    }
}
