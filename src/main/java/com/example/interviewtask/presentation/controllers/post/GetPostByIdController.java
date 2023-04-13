package com.example.interviewtask.presentation.controllers.post;

import com.example.interviewtask.application.post.dto.GetPostByIdDto;
import com.example.interviewtask.application.post.use_case.GetPostByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/posts")
public class GetPostByIdController {
    GetPostByIdUseCase getPostByIdUseCase;

    @Autowired
    public GetPostByIdController(GetPostByIdUseCase getPostByIdUseCase) {
        this.getPostByIdUseCase = getPostByIdUseCase;
    }

    @GetMapping("/detail")
    public GetPostByIdDto getPostById(int postId) {
        return getPostByIdUseCase.execute(postId);
    }
}
