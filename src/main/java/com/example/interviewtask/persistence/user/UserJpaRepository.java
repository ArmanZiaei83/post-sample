package com.example.interviewtask.persistence.user;

import com.example.interviewtask.application.user.repository.UserRepository;
import com.example.interviewtask.domain.user.User;
import com.example.interviewtask.infrastructure.database.user.JpaUserRepository;
import com.example.interviewtask.infrastructure.database.user.UserDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class UserJpaRepository implements UserRepository {
    private JpaUserRepository jpaRepository;

    @Autowired
    public UserJpaRepository(JpaUserRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Integer save(User user) {
        var dataMapper = UserDataMapper.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .isPremium(user.isPremium())
                .build();
        return jpaRepository.save(dataMapper).getId();
    }
}
