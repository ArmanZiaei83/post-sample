package com.example.interviewtask.domain.post;

import com.example.interviewtask.application.post.dto.GetAllPostsDto;
import com.example.interviewtask.application.post.dto.GetPostByIdDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PostRepository {
    int create(Post post);

    Post findById(int id);

    void update(Post post);

    GetPostByIdDto getById(int id);

    Page<GetAllPostsDto> getAll(Pageable pageable);
}
