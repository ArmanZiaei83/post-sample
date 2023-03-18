package com.example.interviewtask.persistence.post;

import com.example.interviewtask.application.post.repository.PostRepository;
import com.example.interviewtask.domain.post.Post;
import com.example.interviewtask.infrastructure.database.post.JpaPostRepository;
import com.example.interviewtask.infrastructure.database.post.PostDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostJpaRepository implements PostRepository {

    private final JpaPostRepository jpaRepository;

    @Autowired
    public PostJpaRepository(JpaPostRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public int create(Post post) {
        var postMapper = new PostDataMapper();
        postMapper.setAuthorId(post.getAuthorId());
        postMapper.setDescription(post.getDescription());
        postMapper.setPremium(post.isPremium());
        postMapper.setContent(post.getContent());
        postMapper.setTitle(post.getTitle());

        return jpaRepository.save(postMapper)
                .getId();
    }
}
