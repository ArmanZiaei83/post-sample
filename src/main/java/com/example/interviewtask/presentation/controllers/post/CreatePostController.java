package com.example.interviewtask.presentation.controllers.post;

import com.example.interviewtask.application.post.dto.CreatePostDto;
import com.example.interviewtask.application.post.use_case.CreatePostUseCase;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/posts")
public class CreatePostController {
    private CreatePostUseCase createPostUseCase;

    @Autowired
    public CreatePostController(CreatePostUseCase createPostUseCase) {
        this.createPostUseCase = createPostUseCase;
    }

    @SneakyThrows
    @PostMapping
    public void createPost(Authentication authentication,
                           @RequestBody CreatePostDto dto) {
        var authorId = authentication.getPrincipal()
                .toString();
        createPostUseCase.execute(authorId, dto);
    }
}
