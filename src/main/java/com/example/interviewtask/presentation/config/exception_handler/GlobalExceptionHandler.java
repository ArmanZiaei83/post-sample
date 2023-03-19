package com.example.interviewtask.presentation.config.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity internalServerErrorException(Exception exception) {
        return new ResponseEntity(exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}