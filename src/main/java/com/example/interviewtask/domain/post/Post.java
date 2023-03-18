package com.example.interviewtask.domain.post;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String description;
    private String content;
    private Integer authorId;
    private LocalDateTime publishDate;
    private boolean isPremium;
}
