package com.aiwsolutions.mongo.converter;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

/**
 * Created by camhoang on 12/5/15.
 */
@EnableMongoRepositories(basePackages = "com.aiwsolutions.mongo.converter.data")
public class RepositoryConfiguration {

    @Bean
    public MongoClient mongoClient() throws UnknownHostException {
        return new MongoClient(new ServerAddress("localhost", 27017));
    }

    @Bean
    @Autowired
    public MongoDbFactory mongoDbFactory(MongoClient mongoClient) {
        return new SimpleMongoDbFactory(mongoClient, "sample");
    }
}
