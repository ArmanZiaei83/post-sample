package com.example.interviewtask.presentation.controllers.post;

import com.example.interviewtask.application.post.dto.GetAllPostsDto;
import com.example.interviewtask.application.post.use_case.GetAllPostsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class GetAllPostsController {
    GetAllPostsUseCase getAllPostsUseCase;

    @Autowired
    public GetAllPostsController(GetAllPostsUseCase getAllPostsUseCase) {
        this.getAllPostsUseCase = getAllPostsUseCase;
    }

    @GetMapping("/all")
    public List<GetAllPostsDto> getAllPosts(Pageable pageable) {
        return getAllPostsUseCase.execute(pageable)
                .getContent();
    }
}
