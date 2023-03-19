package com.example.interviewtask.application.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetAllPostsDto {
    private int id;
    private String title;
    private String description;
}
