package com.example.interviewtask.application.user;

import com.example.interviewtask.application.user.dto.CreateUserDto;
import com.example.interviewtask.application.user.use_cases.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private CreateUserUseCase createUseCase;

    @Autowired
    public UserServiceImpl(CreateUserUseCase createUseCase) {
        this.createUseCase = createUseCase;
    }

    @Override
    public Integer create(CreateUserDto dto) {
        return createUseCase.execute(dto);
    }
}
