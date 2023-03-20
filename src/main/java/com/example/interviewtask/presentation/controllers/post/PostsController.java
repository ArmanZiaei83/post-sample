package com.example.interviewtask.presentation.controllers.post;

import com.example.interviewtask.application.post.PostService;
import com.example.interviewtask.application.post.dto.CreatePostDto;
import com.example.interviewtask.application.post.dto.GetAllPostsDto;
import com.example.interviewtask.application.post.dto.GetPostByIdDto;
import com.example.interviewtask.application.post.dto.UpdatePostDto;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@EnableGlobalAuthentication
public class PostsController {

    private final PostService service;

    @Autowired
    public PostsController(PostService service) {
        this.service = service;
    }

    @SneakyThrows
    @PostMapping
    public int create(Authentication authentication,
                      @RequestBody CreatePostDto dto) {
        return service.create(authentication.getPrincipal()
                .toString(), dto);
    }

    @PutMapping
    public void update(Authentication authentication, @RequestParam int id,
                       @RequestBody @Valid UpdatePostDto dto) {
        service.update(authentication.getPrincipal()
                .toString(), id, dto);
    }

    @GetMapping("/detail")
    public GetPostByIdDto GetById(Authentication authentication,
                                  @RequestParam int id) {
        return service.getById(id);
    }

    @GetMapping("/all")
    public List<GetAllPostsDto> GetAll(Pageable pageable) {
        return service.getAll(pageable)
                .getContent();
    }
}
