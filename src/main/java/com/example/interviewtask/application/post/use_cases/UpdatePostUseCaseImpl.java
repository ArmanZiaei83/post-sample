package com.example.interviewtask.application.post.use_cases;

import com.example.interviewtask.application.post.dto.UpdatePostDto;
import com.example.interviewtask.application.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePostUseCaseImpl implements UpdatePostUseCase {
    private final PostRepository postRepository;

    @Autowired
    public UpdatePostUseCaseImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void execute(int postId, UpdatePostDto dto) {
        var post = postRepository.findById(postId);

        post.setContent(dto.getContent());
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setPremium(dto.isPremium());

        postRepository.update(post);
    }
}
