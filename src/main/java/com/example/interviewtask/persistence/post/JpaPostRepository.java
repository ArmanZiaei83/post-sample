package com.example.interviewtask.persistence.post;

import com.example.interviewtask.application.post.repository.PostRepository;
import com.example.interviewtask.domain.post.Post;
import com.example.interviewtask.infrastructure.database.post.PostDataMapper;
import com.example.interviewtask.infrastructure.database.post.PostJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPostRepository implements PostRepository {

    private PostJpaRepository postRepository;

    public JpaPostRepository(PostJpaRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Long create(Post post) {

        var postMapper = new PostDataMapper();
        postMapper.getAuthor()
                .setId(post.getAuthorId());
        postMapper.setDescription(post.getDescription());
        postMapper.setPremium(post.isPremium());
        postMapper.setContent(post.getContent());
        postMapper.setTitle(post.getTitle());
        return postRepository.save(postMapper)
                .getId();
    }
}
