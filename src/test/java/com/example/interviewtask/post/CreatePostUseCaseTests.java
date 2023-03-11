package com.example.interviewtask.post;

import com.example.interviewtask.domain.Post;
import com.example.interviewtask.infrastructure.database.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class CreatePostUseCaseTests {
    @Test
    public void create_creates_post_properly() {
        var author = User.builder()
                .firstname("dummy-first-name")
                .lastname("dummy-last-name")
                .email("dummy-email")
                .password("dummy-pass")
                .build();
        var post = Post.builder()
                .title("dummy-title")
                .content("dummy-content")
                .publishDate(LocalDateTime.of(2000, 02, 02, 00, 00, 00))
                .isPremium(false)
                .authorId(author.getId())
                .build();


    }
}
