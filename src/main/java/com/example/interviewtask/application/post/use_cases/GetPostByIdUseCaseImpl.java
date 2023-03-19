package com.example.interviewtask.application.post.use_cases;

import com.example.interviewtask.application.post.dto.GetPostByIdDto;
import com.example.interviewtask.application.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPostByIdUseCaseImpl implements GetPostByIdUseCase {
    private PostRepository postRepository;

    @Autowired
    public GetPostByIdUseCaseImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public GetPostByIdDto execute(int postId) {
        return postRepository.getById(postId);
    }
}
