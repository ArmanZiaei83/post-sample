package com.example.interviewtask.application.post.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
public class GetPostByIdDto {
    private String title;
    private String description;
    private String content;
    private LocalDateTime publishedDate;
    private String authorFirstName;
    private String authorLastName;
    private int authorId;
    private boolean isPremium;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public int getAuthorId() {
        return authorId;
    }

    @JsonGetter("isPremium")
    public boolean isPremium() {
        return isPremium;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
}
