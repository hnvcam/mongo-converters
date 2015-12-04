package com.aiwsolutions.mongo.converter;

import com.aiwsolutions.mongo.converter.data.Sample;
import com.aiwsolutions.mongo.converter.data.SampleRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by camhoang on 12/5/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryConfiguration.class, ConverterConfiguration.class})
public class ConverterConfigurationTest {

    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testWriteRead() {
        String id = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now();
        Sample sample = new Sample().setId(id).setTime(now);

        sampleRepository.save(sample);

        Sample storedSample = sampleRepository.findOne(id);
        assertNotNull(storedSample);
        assertThat(storedSample.getTime(), is(now));
    }

    @Test
    public void testReadStoredData() {
        String id = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now();
        DBObject dbObject = new BasicDBObject("_id", id)
                .append("_class", Sample.class.getName())
                .append("time", now);

        mongoTemplate.save(dbObject, "sample");

        Sample storedSample = sampleRepository.findOne(id);
        assertNotNull(storedSample);
        assertThat(storedSample.getTime(), is(now));
    }
}