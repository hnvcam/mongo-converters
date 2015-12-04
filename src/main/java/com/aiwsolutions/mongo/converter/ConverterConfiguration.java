package com.aiwsolutions.mongo.converter;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.mapping.model.CamelCaseAbbreviatingFieldNamingStrategy;
import org.springframework.data.mapping.model.FieldNamingStrategy;
import org.springframework.data.mapping.model.PropertyNameFieldNamingStrategy;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by choang on 12/2/15.
 */
@Configuration
public class ConverterConfiguration {
    @Bean
    @Autowired
    public MongoTemplate mongoTemplate(MongoDbFactory dbFactory, MappingMongoConverter converter) {
        return new MongoTemplate(dbFactory, converter);
    }

    @Bean
    @Autowired
    public MappingMongoConverter mappingMongoConverter(MongoDbFactory mongoDbFactory,
                                                       MongoMappingContext mongoMappingContext,
                                                       CustomConversions customConversions) throws Exception {
        DefaultDbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
        converter.setCustomConversions(customConversions);
        return converter;
    }

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
