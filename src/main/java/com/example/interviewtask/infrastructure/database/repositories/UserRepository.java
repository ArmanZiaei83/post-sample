package com.example.interviewtask.infrastructure.database.repositories;

import com.example.interviewtask.infrastructure.database.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}