package com.example.interviewtask.application.post.use_cases;

import com.example.interviewtask.application.post.dto.GetPostByIdDto;

public interface GetPostByIdUseCase {
    GetPostByIdDto execute(int postId);
}
