package com.example.interviewtask.application.date_time;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DateTimeServiceImpl implements DateTimeService {
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
