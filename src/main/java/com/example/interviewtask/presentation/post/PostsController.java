package com.example.interviewtask.presentation.post;

import com.example.interviewtask.application.post.PostService;
import com.example.interviewtask.application.post.dto.CreatePostDto;
import com.example.interviewtask.application.post.dto.UpdatePostDto;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
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

    @SneakyThrows
    @PostMapping
    public int create(@RequestParam int authorId,
                      @RequestBody @Valid CreatePostDto dto) {
        return service.create(authorId, dto);
    }

    @PutMapping
    public void update(@RequestParam int postId,
                       @RequestBody @Valid UpdatePostDto dto) {
        service.update(postId, dto);
    }
}
