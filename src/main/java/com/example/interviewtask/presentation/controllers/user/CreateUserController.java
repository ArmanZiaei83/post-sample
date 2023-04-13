package com.example.interviewtask.presentation.controllers.user;

import com.example.interviewtask.application.user.dto.CreateUserDto;
import com.example.interviewtask.application.user.use_case.CreateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class CreateUserController {
    CreateUserUseCase createUserUseCase;

    @Autowired
    public CreateUserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public String createUser(@Valid @RequestBody CreateUserDto dto) {
        return createUserUseCase.execute(dto);
    }
}
