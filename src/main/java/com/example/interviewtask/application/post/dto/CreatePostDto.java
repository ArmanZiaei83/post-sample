package com.example.interviewtask.application.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreatePostDto {
    public String title;
    public String content;
    public String description;
    public boolean isPremium;
}
