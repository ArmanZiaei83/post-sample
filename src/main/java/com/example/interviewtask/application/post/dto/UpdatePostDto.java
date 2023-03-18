package com.example.interviewtask.application.post.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UpdatePostDto {
    @NotEmpty
    private String title;
    @NotEmpty

    private String content;
    @NotEmpty

    private String description;
    private boolean isPremium;

}
