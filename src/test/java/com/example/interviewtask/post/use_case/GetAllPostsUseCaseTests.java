package com.example.interviewtask.post.use_case;

import com.example.interviewtask.application.post.use_case.GetAllPostsUseCase;
import com.example.interviewtask.domain.post.PostRepository;
import com.example.interviewtask.infrastructures.BusinessUnitTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetAllPostsUseCaseTests extends BusinessUnitTest {

    @Autowired
    private GetAllPostsUseCase getAllPostsUseCase;

    @MockBean
    private PostRepository postRepository;

    @Test
    public void execute_executes_getting_all_posts_properly() {
        getAllPostsUseCase.execute(null);

        verify(postRepository).getAll(null);
    }
}
