package com.example.interviewtask.domain.post;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String description;
    private String content;
    private String authorFirstName;
    private String authorLastName;
    private Integer authorId;
    private LocalDateTime publishDate;
    private boolean isPremium;
}
