package com.example.interviewtask.application.post.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public class UpdatePostDto {
    @NotEmpty
    private String title;
    @NotEmpty

    private String content;
    @NotEmpty

    private String description;
    private boolean isPremium;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonGetter("isPremium")
    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
}
