package com.example.interviewtask.user.repository;

import com.example.interviewtask.infrastructure.database.user.JpaUserRepository;
import com.example.interviewtask.infrastructure.database.user.UserDataMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserJpaRepositoryTest {

    @Autowired
    private JpaUserRepository jpaRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void save_saves_a_user_properly() {
        var user = UserDataMapper.builder()
                .firstname("dummy-first-name")
                .lastname("dummy-last-name")
                .password("password")
                .email("email")
                .isPremium(false)
                .build();

        jpaRepository.save(user);

        var actualResult = entityManager.find(user.getClass(), user.getId());
        Assert.assertNotNull(actualResult.getId());
        Assert.assertEquals(actualResult.getFirstname(), user.getFirstname());
        Assert.assertEquals(actualResult.isPremium(), user.isPremium());
        Assert.assertEquals(actualResult.getLastname(), user.getLastname());
        Assert.assertEquals(actualResult.getEmail(), user.getEmail());
        Assert.assertEquals(actualResult.getPassword(), user.getPassword());
    }
}
