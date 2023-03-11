package com.example.interviewtask.infrastructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class asd {
    @GetMapping()
    public String Get() {
        return "hello-world";
    }
}
