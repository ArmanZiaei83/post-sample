package com.example.interviewtask.application.user.use_cases;


import com.example.interviewtask.application.user.dto.CreateUserDto;

public interface CreateUserUseCase {
    String execute(CreateUserDto dto);
}
