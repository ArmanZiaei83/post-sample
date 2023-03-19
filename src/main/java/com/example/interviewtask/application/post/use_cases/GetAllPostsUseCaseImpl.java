package com.example.interviewtask.application.post.use_cases;

import com.example.interviewtask.application.post.dto.GetAllPostsDto;
import com.example.interviewtask.application.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetAllPostsUseCaseImpl implements GetAllPostsUseCase {
    private PostRepository postRepository;

    @Autowired
    public GetAllPostsUseCaseImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Page<GetAllPostsDto> execute(Pageable pageable) {
        return postRepository.getAll(pageable);
    }
}
