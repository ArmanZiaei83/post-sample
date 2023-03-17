package com.example.interviewtask.application.user;

import com.example.interviewtask.application.user.dto.CreateUserDto;

public interface UserService {
    Integer create(CreateUserDto dto);
}
