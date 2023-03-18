package com.example.interviewtask.application.post.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuthorNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "AuthorNotFound";
    }
}
