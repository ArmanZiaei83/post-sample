package com.example.interviewtask.application.post;

import com.example.interviewtask.application.post.dto.CreatePostDto;
import com.example.interviewtask.application.post.dto.GetAllPostsDto;
import com.example.interviewtask.application.post.dto.GetPostByIdDto;
import com.example.interviewtask.application.post.dto.UpdatePostDto;
import com.example.interviewtask.application.post.exception.AuthorNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    int create(String authorId, CreatePostDto dto)
            throws AuthorNotFoundException;

    void update(String authorId, int postId, UpdatePostDto dto);

    GetPostByIdDto getById(int postId);

    Page<GetAllPostsDto> getAll(Pageable pageable);
}
