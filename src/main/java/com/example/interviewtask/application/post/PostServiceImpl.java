package com.example.interviewtask.application.post;

import com.example.interviewtask.application.post.dto.CreatePostDto;
import com.example.interviewtask.application.post.use_cases.CreatePostUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostServiceImpl implements PostService {

    private final CreatePostUseCase createPostUseCase;

    @Autowired
    public PostServiceImpl(CreatePostUseCase createPostUseCase) {
        this.createPostUseCase = createPostUseCase;
    }

    public long create(long authorId, CreatePostDto dto) {
        return createPostUseCase.execute(authorId, dto);
    }
}
