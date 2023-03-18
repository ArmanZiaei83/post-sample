package com.example.interviewtask.application.post.use_cases;

import com.example.interviewtask.application.post.dto.UpdatePostDto;

public interface UpdatePostUseCase {
    void execute(int postId, UpdatePostDto dto);
}
