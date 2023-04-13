package com.example.interviewtask.post.use_case;


import com.example.interviewtask.application.post.dto.GetPostByIdDto;
import com.example.interviewtask.application.post.use_case.GetPostByIdUseCase;
import com.example.interviewtask.domain.post.Post;
import com.example.interviewtask.domain.post.PostRepository;
import com.example.interviewtask.domain.user.User;
import com.example.interviewtask.infrastructures.BusinessUnitTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetPostByIdUseCaseTests extends BusinessUnitTest {

    @Autowired
    private GetPostByIdUseCase getPostByIdUseCase;

    @MockBean
    private PostRepository postRepository;

    @Test
    public void execute_executes_getting_a_post_by_id_properly() {
        var author = User.builder()
                .id(randomString())
                .firstname("dummy-first-name")
                .lastname("dummy-last-name")
                .email("dummy-email")
                .build();
        var post = Post.builder()
                .id(randomInt())
                .title("first-post")
                .description("dummy-desc")
                .content("dummy-content")
                .authorId(author.getId())
                .build();
        when(postRepository.getById(post.getId())).thenReturn(
                GetPostByIdDto.builder()
                        .title(post.getTitle())
                        .description(post.getDescription())
                        .content(post.getContent())
                        .authorFirstName(author.getFirstname())
                        .authorLastName(author.getLastname())
                        .authorId(post.getAuthorId())
                        .publishedDate(post.getPublishDate())
                        .isPremium(post.isPremium())
                        .build());

        GetPostByIdDto actualResult = getPostByIdUseCase.execute(post.getId());

        assertEquals(actualResult.getTitle(), post.getTitle());
        assertEquals(actualResult.getDescription(), post.getDescription());
        assertEquals(actualResult.getContent(), post.getContent());
        assertEquals(actualResult.getAuthorId(), post.getAuthorId());
        assertEquals(actualResult.getAuthorFirstName(), author.getFirstname());
        assertEquals(actualResult.getAuthorLastName(), author.getLastname());
        assertEquals(actualResult.getPublishedDate(), post.getPublishDate());
        assertEquals(actualResult.isPremium(), post.isPremium());
    }
}
