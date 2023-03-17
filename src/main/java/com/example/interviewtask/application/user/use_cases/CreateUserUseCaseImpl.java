package com.example.interviewtask.application.user.use_cases;

import com.example.interviewtask.application.user.dto.CreateUserDto;
import com.example.interviewtask.application.user.repository.UserRepository;
import com.example.interviewtask.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private UserRepository repository;

    @Autowired
    public CreateUserUseCaseImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Integer execute(CreateUserDto dto) {
        var user = User.builder()
                .firstname(dto.getFirstName())
                .lastname(dto.getLastName())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .isPremium(dto.isPremium())
                .build();
        return repository.save(user);
    }
}
