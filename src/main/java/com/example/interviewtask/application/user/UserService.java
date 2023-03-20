package com.example.interviewtask.application.user;

import com.example.interviewtask.application.user.dto.CreateUserDto;

public interface UserService {
    String create(CreateUserDto dto);
}
