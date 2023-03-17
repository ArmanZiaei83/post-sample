package com.example.interviewtask.user;

import com.example.interviewtask.application.user.UserServiceImpl;
import com.example.interviewtask.application.user.dto.CreateUserDto;
import com.example.interviewtask.application.user.use_cases.CreateUserUseCase;
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
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTests extends BusinessUnitTest {
    @Autowired
    private UserServiceImpl sut;
    @MockBean
    private CreateUserUseCase createUserUseCase;


    @Test
    public void createUser_creates_user_properly() {
        var dto = CreateUserDto.builder()
                .firstName("first-name")
                .lastName("last-name")
                .email("email")
                .password("pass")
                .isPremium(false)
                .build();
        var userId = randomInt();
        when(createUserUseCase.execute(any(CreateUserDto.class))).thenReturn(
                userId);

        int actualResult = sut.create(dto);

        Assert.assertEquals(actualResult, userId);
        Mockito.verify(createUserUseCase)
                .execute(dto);
    }
}