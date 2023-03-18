package com.example.interviewtask.infrastructure.database.post;

import com.example.interviewtask.application.post.dto.GetAllPostsDto;
import com.example.interviewtask.infrastructure.entity_mappers.GetAllPostDtoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface JpaPostRepository extends JpaRepository<PostDataMapper, Long> {
    Optional<PostDataMapper> findById(int id);

    PostDataMapper save(PostDataMapper post);

    Page<PostDataMapper> findAll(Pageable pageable);

    default Page<GetAllPostsDto> findAllDto(Pageable pageable) {
        Page<PostDataMapper> entities = findAll(pageable);
        List<GetAllPostsDto> data = entities.stream()
                .map(entity -> GetAllPostDtoMapper.toDto(entity))
                .collect(Collectors.toList());
        return new PageImpl<>(data, pageable, entities.getTotalElements());
    }
}