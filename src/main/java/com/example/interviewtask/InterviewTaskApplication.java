package com.example.interviewtask;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Application APIs", version = "1.0", description = "API Documentation"))
public class InterviewTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterviewTaskApplication.class, args);
    }

}
