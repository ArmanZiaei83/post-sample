package com.example.interviewtask.domain.user;

import com.example.interviewtask.infrastructure.database.user.UserDataMapper;

import java.util.Optional;

public interface UserRepository {
    String save(User user);

    boolean exists(String id);

    Optional<UserDataMapper> findByUsername(String id);
}
