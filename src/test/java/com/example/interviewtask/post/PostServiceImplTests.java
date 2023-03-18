package com.example.interviewtask.post;

import com.example.interviewtask.application.post.PostServiceImpl;
import com.example.interviewtask.application.post.dto.CreatePostDto;
import com.example.interviewtask.application.post.dto.UpdatePostDto;
import com.example.interviewtask.application.post.use_cases.CreatePostUseCase;
import com.example.interviewtask.application.post.use_cases.UpdatePostUseCase;
import com.example.interviewtask.infrastructures.BusinessUnitTest;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceImplTests extends BusinessUnitTest {

    @Autowired
    private PostServiceImpl sut;
    @MockBean
    private CreatePostUseCase createPostUseCase;
    @MockBean
    private UpdatePostUseCase updatePostUseCase;

    @SneakyThrows
    @Test
    public void create_creates_post_properly() {
        var dto = CreatePostDto.builder()
                .title("dummy-title")
                .description("dummy-desc")
                .content("dummy-content")
                .isPremium(false)
                .build();
        var postId = randomInt();
        when(createPostUseCase.execute(anyInt(),
                any(CreatePostDto.class))).thenReturn(postId);

        var actualResult = sut.create(randomInt(), dto);

        Assert.assertEquals(actualResult, postId);
        verify(createPostUseCase).execute(anyInt(), any(CreatePostDto.class));
    }

    @Test
    public void update_updates_a_post_properly() {
        var postId = randomInt();
        var dto = UpdatePostDto.builder()
                .title("new-title")
                .content("new-content")
                .description("new-desc")
                .isPremium(true)
                .build();

        sut.update(postId, dto);

        verify(updatePostUseCase).execute(postId, dto);
    }
}
