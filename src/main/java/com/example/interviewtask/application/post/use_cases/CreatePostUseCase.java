package com.example.interviewtask.application.post.use_cases;

import com.example.interviewtask.application.post.dto.CreatePostDto;
import com.example.interviewtask.application.post.exception.AuthorNotFoundException;

public interface CreatePostUseCase {
    int execute(String authorId, CreatePostDto dto)
            throws AuthorNotFoundException;
}
