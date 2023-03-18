package com.example.interviewtask.application.post;

import com.example.interviewtask.application.post.dto.CreatePostDto;

public interface PostService {
    int create(int authorId, CreatePostDto dto);
}
