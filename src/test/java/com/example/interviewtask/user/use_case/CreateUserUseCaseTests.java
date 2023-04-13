package com.example.interviewtask.user.use_case;

import com.example.interviewtask.application.user.dto.CreateUserDto;
import com.example.interviewtask.application.user.use_case.CreateUserUseCase;
import com.example.interviewtask.domain.user.UserRepository;
import com.example.interviewtask.infrastructures.BusinessUnitTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)

@SpringBootTest
public class CreateUserUseCaseTests extends BusinessUnitTest {

    @Autowired
    CreateUserUseCase createUserUseCase;
    @MockBean
    UserRepository userRepository;

    @Test

    public void execute_executes_creating_user_properly() {
        var dto = CreateUserDto.builder()
                .firstName("dummy-first-name")
                .lastName("dummy-last-name")
                .email("dummy-email")
                .password("dummy-pass")
                .isPremium(false)
                .build();
        var userId = randomString();
        when(userRepository.save(any())).thenReturn(userId);

        var actualResult = createUserUseCase.execute(dto);

        Assert.assertEquals(actualResult, userId);
    }
}
