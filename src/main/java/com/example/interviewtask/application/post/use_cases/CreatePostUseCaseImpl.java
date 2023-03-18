package com.example.interviewtask.application.post.use_cases;

import com.example.interviewtask.application.date_time.DateTimeService;
import com.example.interviewtask.application.post.dto.CreatePostDto;
import com.example.interviewtask.application.post.repository.PostRepository;
import com.example.interviewtask.domain.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePostUseCaseImpl implements CreatePostUseCase {
    private final PostRepository postRepository;
    private final DateTimeService dateTimeService;

    @Autowired
    public CreatePostUseCaseImpl(PostRepository postRepository,
                                 DateTimeService dateTimeService) {
        this.postRepository = postRepository;
        this.dateTimeService = dateTimeService;
    }

    @Override
    public int execute(int authorId, CreatePostDto dto) {
        var post = new Post();
        post.setPremium(dto.isPremium());
        post.setAuthorId(authorId);
        post.setContent(dto.getContent());
        post.setDescription(dto.getDescription());
        post.setTitle(dto.getTitle());
        post.setPublishDate(dateTimeService.now());

        return postRepository.create(post);
    }
}
