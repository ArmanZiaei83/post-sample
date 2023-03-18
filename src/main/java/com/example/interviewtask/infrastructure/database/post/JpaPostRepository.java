package com.example.interviewtask.infrastructure.database.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPostRepository extends JpaRepository<PostDataMapper, Long> {
    Optional<PostDataMapper> findById(long postId);
    PostDataMapper save(PostDataMapper post);
}