package com.example.interviewtask.application.date_time;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DateTimeServiceImpl implements DateTimeService {
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
