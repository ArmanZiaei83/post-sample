package com.example.interviewtask.application.post.use_case;

import com.example.interviewtask.application.post.dto.GetPostByIdDto;
import com.example.interviewtask.domain.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class GetPostByIdUseCase {
    private PostRepository postRepository;

    @Autowired
    public GetPostByIdUseCase(
            @Qualifier("createPostRepository") PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public GetPostByIdDto execute(int postId) {
        return postRepository.getById(postId);
    }
}
