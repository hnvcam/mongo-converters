package com.aiwsolutions.mongo.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.Duration;

/**
 * Created by camhoang on 12/20/15.
 */
public class DurationReader implements Converter<String, Duration> {
    public Duration convert(String s) {
        return Duration.parse(s);
    }
}
