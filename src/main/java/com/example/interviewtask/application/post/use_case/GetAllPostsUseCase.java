package com.example.interviewtask.application.post.use_case;

import com.example.interviewtask.application.post.dto.GetAllPostsDto;
import com.example.interviewtask.domain.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class GetAllPostsUseCase {
    private PostRepository postRepository;

    @Autowired
    public GetAllPostsUseCase(
            @Qualifier("createPostRepository") PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<GetAllPostsDto> execute(Pageable pageable) {
        return postRepository.getAll(pageable);
    }
}
