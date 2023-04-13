package com.example.interviewtask.infrastructure.date_time;

import java.time.LocalDateTime;

public class DateTimeServiceImpl implements DateTimeService {
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
