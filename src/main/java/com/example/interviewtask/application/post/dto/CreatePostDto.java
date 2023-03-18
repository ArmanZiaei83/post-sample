package com.example.interviewtask.application.post.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreatePostDto {
    @NotEmpty
    public String title;
    @NotEmpty

    public String content;
    @NotEmpty

    public String description;
    @NotNull
    public boolean isPremium;
}
