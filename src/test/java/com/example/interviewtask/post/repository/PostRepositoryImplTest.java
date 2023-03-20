package com.example.interviewtask.post.repository;

import com.example.interviewtask.infrastructure.database.post.JpaPostRepository;
import com.example.interviewtask.infrastructure.database.post.PostDataMapper;
import com.example.interviewtask.infrastructure.database.user.UserDataMapper;
import com.example.interviewtask.infrastructures.BusinessUnitTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryImplTest extends BusinessUnitTest {

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
                .authorId(randomString())
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

    @Test
    public void save_updates_an_existing_post_properly() {
        var post = PostDataMapper.builder()
                .title("dummy-title")
                .description("dummy-desc")
                .content("dummy-content")
                .authorId(randomString())
                .isPremium(false)
                .build();
        entityManager.persist(post);

        post.setDescription("new-desc");
        post.setContent("new-content");
        post.setPremium(true);
        post.setTitle("new-title");
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

    @Test
    public void findAllDto_finds_all_posts_with_pagination_properly() {
        var firstPost = createPost();
        entityManager.persist(firstPost);
        var secondPost = createPost();
        entityManager.persist(secondPost);
        var pagination = PageRequest.of(0, 2);

        var actualResult = jpaRepository.findAllDto(pagination)
                .toList();
        var firstActualPost = actualResult.get(0);
        var secondActualPost = actualResult.get(1);

        Assert.assertEquals(actualResult.size(), 2);
        Assert.assertEquals(firstActualPost.getId(), firstPost.getId());
        Assert.assertEquals(firstActualPost.getDescription(),
                firstPost.getDescription());
        Assert.assertEquals(firstActualPost.getTitle(), firstPost.getTitle());
        Assert.assertEquals(secondActualPost.getId(), secondPost.getId());
        Assert.assertEquals(secondActualPost.getDescription(),
                secondPost.getDescription());
        Assert.assertEquals(secondActualPost.getTitle(), secondPost.getTitle());
    }

    private PostDataMapper createPost() {
        var author = UserDataMapper.builder()
                .id(randomString())
                .firstname("dummy-first-name")
                .lastname("dummy-last-name")
                .email("dummy-email")
                .password("123456789")
                .isPremium(false)
                .build();
        entityManager.persist(author);
        var post = PostDataMapper.builder()
                .title("dummy-title")
                .authorId(author.getId()
                        .toString())
                .content("dummy-content")
                .publishDate(LocalDateTime.of(2000, 02, 02, 0, 0, 0))
                .isPremium(false)
                .description("dummy-desc")
                .build();
        return post;
    }
}
