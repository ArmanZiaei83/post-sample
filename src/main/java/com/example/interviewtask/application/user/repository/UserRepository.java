package com.example.interviewtask.application.user.repository;

import com.example.interviewtask.domain.user.User;

public interface UserRepository  {
    Integer save(User user);

    boolean exists(int id);
}
