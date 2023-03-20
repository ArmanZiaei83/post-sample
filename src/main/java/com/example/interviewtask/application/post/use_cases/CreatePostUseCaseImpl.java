package com.example.interviewtask.application.post.use_cases;

import com.example.interviewtask.infrastructure.date_time.DateTimeService;
import com.example.interviewtask.application.post.dto.CreatePostDto;
import com.example.interviewtask.application.post.exception.AuthorNotFoundException;
import com.example.interviewtask.application.post.repository.PostRepository;
import com.example.interviewtask.application.user.repository.UserRepository;
import com.example.interviewtask.domain.post.Post;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePostUseCaseImpl implements CreatePostUseCase {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final DateTimeService dateTimeService;

    @Autowired
    public CreatePostUseCaseImpl(PostRepository postRepository,
                                 UserRepository userRepository,
                                 DateTimeService dateTimeService) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.dateTimeService = dateTimeService;
    }

    @SneakyThrows
    @Override
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
