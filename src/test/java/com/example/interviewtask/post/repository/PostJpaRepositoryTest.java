package com.example.interviewtask.post.repository;

import com.example.interviewtask.infrastructure.database.post.JpaPostRepository;
import com.example.interviewtask.infrastructure.database.post.PostDataMapper;
import com.example.interviewtask.infrastructures.BusinessUnitTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostJpaRepositoryTest extends BusinessUnitTest {

    @Autowired
    private JpaPostRepository jpaRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void save_saves_a_user_properly() {
        var post = PostDataMapper.builder()
                .title("dummy-title")
                .description("dummy-desc")
                .content("dummy-content")
                .authorId(randomInt())
                .isPremium(false)
                .build();

        jpaRepository.save(post);

        var actualResult = entityManager.find(post.getClass(), post.getId());
        Assert.assertNotNull(actualResult.getId());
        Assert.assertEquals(actualResult.getTitle(), post.getTitle());
        Assert.assertEquals(actualResult.isPremium(), post.isPremium());
        Assert.assertEquals(actualResult.getContent(), post.getContent());
        Assert.assertEquals(actualResult.getDescription(),
                post.getDescription());
        Assert.assertEquals(actualResult.getAuthorId(), post.getAuthorId());
    }
}
