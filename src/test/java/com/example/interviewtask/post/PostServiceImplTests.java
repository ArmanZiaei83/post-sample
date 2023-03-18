package com.example.interviewtask.post;

import com.example.interviewtask.application.post.PostServiceImpl;
import com.example.interviewtask.application.post.dto.CreatePostDto;
import com.example.interviewtask.application.post.use_cases.CreatePostUseCase;
import com.example.interviewtask.infrastructures.BusinessUnitTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceImplTests extends BusinessUnitTest {

    @Autowired
    private PostServiceImpl sut;
    @MockBean
    private CreatePostUseCase createPostUseCase;

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
        Mockito.verify(createPostUseCase)
                .execute(anyInt(), any(CreatePostDto.class));
    }
}
