package com.example.interviewtask.application.post.use_cases;

import com.example.interviewtask.application.post.dto.GetAllPostsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetAllPostsUseCase {
    Page<GetAllPostsDto> execute(Pageable pageable);
}
