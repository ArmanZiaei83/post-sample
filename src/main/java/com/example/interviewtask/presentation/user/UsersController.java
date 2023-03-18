package com.example.interviewtask.presentation.user;

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

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public int create(@Valid @RequestBody CreateUserDto dto) {
        return userService.create(dto);
    }
}
