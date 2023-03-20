package com.example.interviewtask.persistence.user;

import com.example.interviewtask.application.user.repository.UserRepository;
import com.example.interviewtask.domain.user.User;
import com.example.interviewtask.infrastructure.database.user.JpaUserRepository;
import com.example.interviewtask.infrastructure.database.user.UserDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaRepository;

    @Autowired
    public UserRepositoryImpl(JpaUserRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public String save(User user) {
        var dataMapper = UserDataMapper.builder()
                .id(UUID.randomUUID()
                        .toString())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .isPremium(user.isPremium())
                .role(user.getRole())
                .build();
        return jpaRepository.save(dataMapper)
                .getId()
                .toString();
    }

    @Override
    public boolean exists(String id) {
        return jpaRepository.findById(id)
                .isPresent();
    }

    @Override
    public Optional<UserDataMapper> findById(String id) {
        return jpaRepository.findById(id);
    }
}
