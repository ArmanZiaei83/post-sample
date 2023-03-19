package com.example.interviewtask.infrastructure.entity_mappers;

import com.example.interviewtask.application.post.dto.GetPostByIdDto;
import com.example.interviewtask.infrastructure.database.post.PostDataMapper;

public class GetPostByIdDtoMapper {
    public static GetPostByIdDto toDto(PostDataMapper post) {
        return GetPostByIdDto.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .description(post.getDescription())
                .publishedDate(post.getPublishDate())
                .authorId(post.getAuthorId())
                .authorFirstName(post.getAuthor()
                        .getFirstname())
                .authorLastName(post.getAuthor()
                        .getLastname())
                .isPremium(post.isPremium())
                .build();
    }
}
