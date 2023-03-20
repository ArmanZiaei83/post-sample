package com.example.interviewtask.presentation.controllers.user;

import com.example.interviewtask.application.user.UserService;
import com.example.interviewtask.application.user.dto.CreateUserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {

    private final UserService service;

    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public String create(@Valid @RequestBody CreateUserDto dto) {
        return service.create(dto);
    }
}
