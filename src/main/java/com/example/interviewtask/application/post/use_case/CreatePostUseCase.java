package com.example.interviewtask.application.post.use_case;

import com.example.interviewtask.application.post.dto.CreatePostDto;
import com.example.interviewtask.application.post.exception.AuthorNotFoundException;
import com.example.interviewtask.domain.post.Post;
import com.example.interviewtask.domain.post.PostRepository;
import com.example.interviewtask.domain.user.UserRepository;
import com.example.interviewtask.infrastructure.date_time.DateTimeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CreatePostUseCase {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final DateTimeService dateTimeService;

    @Autowired
    public CreatePostUseCase(
            @Qualifier("createPostRepository") PostRepository postRepository,
            @Qualifier("createUserRepository") UserRepository userRepository,
            @Qualifier("createDateTimeService") DateTimeService dateTimeService) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.dateTimeService = dateTimeService;
    }

    @SneakyThrows
    public int execute(String authorId, CreatePostDto dto) {
        throwExceptionWhenAuthorIdIsInvalid(authorId);

        var post = new Post();
        post.setPremium(dto.isPremium());
        post.setAuthorId(authorId);
        post.setContent(dto.getContent());
        post.setDescription(dto.getDescription());
        post.setTitle(dto.getTitle());
        post.setPublishDate(dateTimeService.now());

        return postRepository.create(post);
    }

    private void throwExceptionWhenAuthorIdIsInvalid(String authorId)
            throws AuthorNotFoundException {
        boolean authorExists = userRepository.exists(authorId);
        if (!authorExists) throw new AuthorNotFoundException();
    }
}
