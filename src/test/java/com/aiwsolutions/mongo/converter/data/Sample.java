package com.aiwsolutions.mongo.converter.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by camhoang on 12/5/15.
 */
@Document
public class Sample {

    @Id
    private String id;

    private LocalDateTime localDateTime;

    private LocalDate localDate;

    private Duration duration;

    private LocalTime localTime;

    public String getId() {
        return id;
    }

    public Sample setId(String id) {
        this.id = id;
        return this;
    }

    public Duration getDuration() {
        return duration;
    }

    public Sample setDuration(Duration duration) {
        this.duration = duration;
        return this;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Sample setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
        return this;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Sample setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public Sample setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
        return this;
    }
}
