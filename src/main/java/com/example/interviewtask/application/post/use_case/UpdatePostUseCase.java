package com.example.interviewtask.application.post.use_case;

import com.example.interviewtask.application.post.dto.UpdatePostDto;
import com.example.interviewtask.application.post.exception.OnlyAuthorCanEditPostException;
import com.example.interviewtask.domain.post.Post;
import com.example.interviewtask.domain.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UpdatePostUseCase {
    private final PostRepository postRepository;

    @Autowired
    public UpdatePostUseCase(
            @Qualifier("createPostRepository") PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void execute(String authorId, int postId, UpdatePostDto dto) {
        var post = postRepository.findById(postId);
        throwExceptionWhenAuthorIdIsInvalid(authorId, post);

        post.setContent(dto.getContent());
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setPremium(dto.isPremium());

        postRepository.update(post);
    }

    private void throwExceptionWhenAuthorIdIsInvalid(String authorId,
                                                     Post post) {
        if (post.getAuthorId() != authorId)
            throw new OnlyAuthorCanEditPostException();
    }
}
