package com.example.interviewtask.post.use_case;

import com.example.interviewtask.application.post.dto.UpdatePostDto;
import com.example.interviewtask.application.post.exception.OnlyAuthorCanEditPostException;
import com.example.interviewtask.application.post.use_case.UpdatePostUseCase;
import com.example.interviewtask.domain.post.Post;
import com.example.interviewtask.domain.post.PostRepository;
import com.example.interviewtask.infrastructures.BusinessUnitTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdatePostUseCaseTests extends BusinessUnitTest {

    @Autowired
    private UpdatePostUseCase updatePostUseCase;
    @MockBean
    private PostRepository postRepository;

    @Test
    public void execute_executes_updating_a_post_properly() {
        var post = Post.builder()
                .id(randomInt())
                .title("dummy-title")
                .content("dummy-content")
                .description("dummy-desc")
                .publishDate(LocalDateTime.of(2000, 02, 02, 02, 02))
                .authorId(randomString())
                .isPremium(false)
                .build();
        when(postRepository.findById(post.getId())).thenReturn(post);
        var dto = UpdatePostDto.builder()
                .title("new-title")
                .content("new-content")
                .description("new-desc")
                .isPremium(true)
                .build();

        updatePostUseCase.execute(post.getAuthorId(), post.getId(), dto);

        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setDescription(dto.getDescription());
        post.setPremium(dto.isPremium());
        verify(postRepository).update(post);
    }

    @Test
    public void update_throws_OnlyAuthorCanEditPostException_when_user_is_not_author_of_the_post() {
        var post = Post.builder()
                .id(randomInt())
                .title("dummy-title")
                .content("dummy-content")
                .description("dummy-desc")
                .publishDate(LocalDateTime.of(2000, 02, 02, 02, 02))
                .authorId(randomString())
                .isPremium(false)
                .build();
        var invalidAuthorId = randomString();
        when(postRepository.findById(post.getId())).thenReturn(post);
        var dto = UpdatePostDto.builder()
                .build();

        var exception = assertThrows(OnlyAuthorCanEditPostException.class,
                () -> updatePostUseCase.execute(invalidAuthorId, post.getId(),
                        dto));

        assertEquals(exception.getClass(),
                OnlyAuthorCanEditPostException.class);
    }
}
