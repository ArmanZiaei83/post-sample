package com.example.interviewtask.application.post.use_cases;

import com.example.interviewtask.application.post.dto.CreatePostDto;

public interface CreatePostUseCase {
    long execute(long authorId, CreatePostDto dto);
}
