package com.example.interviewtask.application.post;

import com.example.interviewtask.application.post.dto.CreatePostDto;
import com.example.interviewtask.application.post.dto.GetPostByIdDto;
import com.example.interviewtask.application.post.dto.UpdatePostDto;
import com.example.interviewtask.application.post.exception.AuthorNotFoundException;
import com.example.interviewtask.application.post.use_cases.CreatePostUseCase;
import com.example.interviewtask.application.post.use_cases.GetPostByIdUseCase;
import com.example.interviewtask.application.post.use_cases.UpdatePostUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final CreatePostUseCase createPostUseCase;
    private final UpdatePostUseCase updatePostUseCase;
    private GetPostByIdUseCase getPostByIdUseCase;

    @Autowired
    public PostServiceImpl(CreatePostUseCase createPostUseCase,
                           UpdatePostUseCase updatePostUseCase,
                           GetPostByIdUseCase getPostByIdUseCase) {
        this.createPostUseCase = createPostUseCase;
        this.updatePostUseCase = updatePostUseCase;
        this.getPostByIdUseCase = getPostByIdUseCase;
    }

    public int create(int authorId, CreatePostDto dto)
            throws AuthorNotFoundException {
        return createPostUseCase.execute(authorId, dto);
    }

    @Override
    public void update(int postId, UpdatePostDto dto) {
        updatePostUseCase.execute(postId, dto);
    }

    @Override
    public GetPostByIdDto getById(int postId) {
        return getPostByIdUseCase.execute(postId);
    }
}
