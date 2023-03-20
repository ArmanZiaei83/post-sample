package com.example.interviewtask.application.user.repository;

import com.example.interviewtask.domain.user.User;
import com.example.interviewtask.infrastructure.database.user.UserDataMapper;

import java.util.Optional;

public interface UserRepository {
    String save(User user);

    boolean exists(String id);

    Optional<UserDataMapper> findById(String id);
}
