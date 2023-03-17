package com.example.interviewtask.application.post;

import com.example.interviewtask.application.post.dto.CreatePostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    long create(long authorId, CreatePostDto dto);
}
