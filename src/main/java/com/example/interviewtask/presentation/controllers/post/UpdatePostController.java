package com.example.interviewtask.presentation.controllers.post;

import com.example.interviewtask.application.post.dto.UpdatePostDto;
import com.example.interviewtask.application.post.use_case.UpdatePostUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/posts")
@EnableGlobalAuthentication
public class UpdatePostController {
    private UpdatePostUseCase updatePostUseCase;

    @Autowired
    public UpdatePostController(UpdatePostUseCase updatePostUseCase) {
        this.updatePostUseCase = updatePostUseCase;
    }

    @PutMapping
    public void updatePost(Authentication authentication, int postId,
                           UpdatePostDto dto) {
        var authorId = authentication.getPrincipal()
                .toString();
        updatePostUseCase.execute(authorId, postId, dto);
    }
}
