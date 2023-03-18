package com.example.interviewtask.presentation.post;

import com.example.interviewtask.application.post.PostService;
import com.example.interviewtask.application.post.dto.CreatePostDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/posts")
public class PostsController {

    private final PostService service;

    @Autowired
    public PostsController(PostService service) {
        this.service = service;
    }

    @PostMapping
    public int create(@RequestParam int authorId,
                      @RequestBody @Valid CreatePostDto dto) {
        return service.create(authorId, dto);
    }
}
