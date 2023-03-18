package com.example.interviewtask.application.post.repository;

import com.example.interviewtask.application.post.dto.GetPostByIdDto;
import com.example.interviewtask.domain.post.Post;


public interface PostRepository {
    int create(Post post);

    Post findById(int id);

    void update(Post post);

    GetPostByIdDto getById(int id);
}
