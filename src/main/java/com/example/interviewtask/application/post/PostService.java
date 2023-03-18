package com.example.interviewtask.application.post;

import com.example.interviewtask.application.post.dto.CreatePostDto;
import com.example.interviewtask.application.post.dto.GetPostByIdDto;
import com.example.interviewtask.application.post.dto.UpdatePostDto;
import com.example.interviewtask.application.post.exception.AuthorNotFoundException;

public interface PostService {
    int create(int authorId, CreatePostDto dto)
            throws AuthorNotFoundException;

    void update(int postId, UpdatePostDto dto);

    GetPostByIdDto getById(int postId);
}
