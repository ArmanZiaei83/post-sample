package com.example.interviewtask.application.user.repository;

import com.example.interviewtask.domain.user.User;
import com.example.interviewtask.infrastructure.database.user.UserDataMapper;

import java.util.Optional;

public interface UserRepository {
    Integer save(User user);

    boolean exists(int id);

    Optional<UserDataMapper> findByEmail(String username);
}
