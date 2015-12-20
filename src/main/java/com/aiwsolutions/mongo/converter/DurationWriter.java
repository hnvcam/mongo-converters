package com.aiwsolutions.mongo.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.Duration;

/**
 * Created by camhoang on 12/20/15.
 */
public class DurationWriter implements Converter<Duration, String> {
    public String convert(Duration duration) {
        return duration.toString();
    }
}
