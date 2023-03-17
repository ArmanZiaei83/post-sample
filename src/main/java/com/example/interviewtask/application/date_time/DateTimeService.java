package com.example.interviewtask.application.date_time;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface DateTimeService {
    LocalDateTime now();
}
