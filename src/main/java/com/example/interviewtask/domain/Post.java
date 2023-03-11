package com.example.interviewtask.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Post {
    private String title;
    private String description;
    private String content;
    private long authorId;
    private LocalDateTime publishDate;
    private boolean isPremium;
}