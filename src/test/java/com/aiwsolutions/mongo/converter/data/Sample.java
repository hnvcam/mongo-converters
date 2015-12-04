package com.aiwsolutions.mongo.converter.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by camhoang on 12/5/15.
 */
@Document
public class Sample {

    @Id
    private String id;

    private LocalDateTime time;

    public String getId() {
        return id;
    }

    public Sample setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Sample setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }
}
