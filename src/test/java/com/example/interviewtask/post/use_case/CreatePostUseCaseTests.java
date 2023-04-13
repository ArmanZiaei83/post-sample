package com.example.interviewtask.post.use_case;

import com.example.interviewtask.application.post.dto.CreatePostDto;
import com.example.interviewtask.application.post.exception.AuthorNotFoundException;
import com.example.interviewtask.application.post.use_case.CreatePostUseCase;
import com.example.interviewtask.domain.post.Post;
import com.example.interviewtask.domain.post.PostRepository;
import com.example.interviewtask.domain.user.UserRepository;
import com.example.interviewtask.infrastructure.date_time.DateTimeService;
import com.example.interviewtask.infrastructures.BusinessUnitTest;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatePostUseCaseTests extends BusinessUnitTest {

    @Autowired
    private CreatePostUseCase createPostUseCase;

    @MockBean
    private PostRepository postRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private DateTimeService dateTimeService;

    @Before
    public void MockDateTime() {
        when(dateTimeService.now()).thenReturn(
                LocalDateTime.of(2000, 02, 02, 02, 02));
    }

    @SneakyThrows
    @Test
    public void execute_executes_creation_of_a_post_properly() {
        var dto = CreatePostDto.builder()
                .title("dummy-title")
                .description("dummy-desc")
                .content("dummy-content")
                .isPremium(false)
                .build();
        var authorId = randomString();
        int postId = randomInt();
        when(postRepository.create(any(Post.class))).thenReturn(postId);
        when(userRepository.exists(authorId)).thenReturn(true);

        int actualResult = createPostUseCase.execute(authorId, dto);

        Assert.assertEquals(actualResult, postId);
        verify(dateTimeService).now();
        verify(postRepository).create(any(Post.class));
    }

    @Test
    public void execute_throws_authorNotFoundException_when_author_id_is_invalid() {
        var dto = CreatePostDto.builder()
                .title("dummy-title")
                .description("dummy-desc")
                .content("dummy-content")
                .isPremium(false)
                .build();
        var invalidAuthorId = "invalid_id";
        int postId = randomInt();
        when(postRepository.create(any(Post.class))).thenReturn(postId);

        var exception = assertThrows(AuthorNotFoundException.class,
                () -> createPostUseCase.execute(invalidAuthorId, dto));

        assertEquals(exception.getClass(), AuthorNotFoundException.class);
    }

}
