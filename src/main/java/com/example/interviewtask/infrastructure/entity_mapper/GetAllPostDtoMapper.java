package com.example.interviewtask.infrastructure.entity_mapper;

import com.example.interviewtask.application.post.dto.GetAllPostsDto;
import com.example.interviewtask.infrastructure.database.post.PostDataMapper;

public class GetAllPostDtoMapper {
    public static GetAllPostsDto toDto(PostDataMapper post) {
        return GetAllPostsDto.builder()
                .description(post.getDescription())
                .title(post.getTitle())
                .id(post.getId())
                .build();
    }
}