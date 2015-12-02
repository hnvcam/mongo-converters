package com.aiwsolutions.mongo.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.CustomConversions;

import java.util.Arrays;
import java.util.List;

/**
 * Created by choang on 12/2/15.
 */
@Configuration
public class ConverterConfiguration {

    @Bean
    public CustomConversions customConversions() {
        return new CustomConversions(customConverters());
    }

    private List<? extends Converter> customConverters() {
        return Arrays.asList(
                new LocalDateTimeReader(),
                new LocalDateTimeWriter()
        );
    }
}
