package com.example.interviewtask.infrastructure.database.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository
        extends JpaRepository<UserDataMapper, Integer> {

    Optional<UserDataMapper> findByEmail(String email);
    UserDataMapper save(UserDataMapper dataMapper);
}