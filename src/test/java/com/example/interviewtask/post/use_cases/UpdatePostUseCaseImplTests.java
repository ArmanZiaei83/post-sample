package com.example.interviewtask.post.use_cases;

import com.example.interviewtask.application.post.dto.UpdatePostDto;
import com.example.interviewtask.application.post.repository.PostRepository;
import com.example.interviewtask.application.post.use_cases.UpdatePostUseCaseImpl;
import com.example.interviewtask.domain.post.Post;
import com.example.interviewtask.infrastructures.BusinessUnitTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdatePostUseCaseImplTests extends BusinessUnitTest {

    @Autowired
    private UpdatePostUseCaseImpl updatePostUseCase;
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
                .authorId(randomInt())
                .isPremium(false)
                .build();
        when(postRepository.findById(post.getId())).thenReturn(post);
        var dto = UpdatePostDto.builder()
                .title("new-title")
                .content("new-content")
                .description("new-desc")
                .isPremium(true)
                .build();

        updatePostUseCase.execute(post.getId(), dto);

        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setDescription(dto.getDescription());
        post.setPremium(dto.isPremium());
        verify(postRepository).update(post);
    }
}
