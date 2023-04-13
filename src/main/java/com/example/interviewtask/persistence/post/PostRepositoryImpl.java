package com.example.interviewtask.persistence.post;

import com.example.interviewtask.application.post.dto.GetAllPostsDto;
import com.example.interviewtask.application.post.dto.GetPostByIdDto;
import com.example.interviewtask.domain.post.Post;
import com.example.interviewtask.domain.post.PostRepository;
import com.example.interviewtask.infrastructure.database.post.JpaPostRepository;
import com.example.interviewtask.infrastructure.database.post.PostDataMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class PostRepositoryImpl implements PostRepository {

    private final JpaPostRepository jpaRepository;

    public PostRepositoryImpl(JpaPostRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public int create(Post post) {
        var postMapper = new PostDataMapper();
        postMapper.setAuthorId(UUID.fromString(post.getAuthorId())
                .toString());
        postMapper.setDescription(post.getDescription());
        postMapper.setPremium(post.isPremium());
        postMapper.setContent(post.getContent());
        postMapper.setPublishDate(post.getPublishDate());
        postMapper.setTitle(post.getTitle());

        return jpaRepository.save(postMapper)
                .getId();
    }

    @Override
    public Post findById(int id) {
        var postData = jpaRepository.findById(id)
                .get();
        return Post.builder()
                .id(postData.getId())
                .title(postData.getTitle())
                .description(postData.getDescription())
                .isPremium(postData.isPremium())
                .authorId(postData.getAuthorId())
                .content(postData.getContent())
                .publishDate(postData.getPublishDate())
                .build();
    }

    @Override
    public void update(Post post) {
        var postData = PostDataMapper.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .content(post.getContent())
                .isPremium(post.isPremium())
                .authorId(post.getAuthorId())
                .publishDate(post.getPublishDate())
                .build();
        jpaRepository.save(postData);
    }

    @Override
    public GetPostByIdDto getById(int id) {
        return jpaRepository.findByIdDto(id);
    }

    @Override
    public Page<GetAllPostsDto> getAll(Pageable pageable) {
        return jpaRepository.findAllDto(pageable);
    }
}
