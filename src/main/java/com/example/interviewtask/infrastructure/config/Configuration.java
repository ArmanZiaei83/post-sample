package com.example.interviewtask.infrastructure.config;

import com.example.interviewtask.application.post.use_case.CreatePostUseCase;
import com.example.interviewtask.application.post.use_case.GetAllPostsUseCase;
import com.example.interviewtask.application.post.use_case.GetPostByIdUseCase;
import com.example.interviewtask.application.post.use_case.UpdatePostUseCase;
import com.example.interviewtask.application.user.use_case.CreateUserUseCase;
import com.example.interviewtask.domain.post.PostRepository;
import com.example.interviewtask.domain.user.UserRepository;
import com.example.interviewtask.infrastructure.database.post.JpaPostRepository;
import com.example.interviewtask.infrastructure.database.user.JpaUserRepository;
import com.example.interviewtask.infrastructure.date_time.DateTimeService;
import com.example.interviewtask.infrastructure.date_time.DateTimeServiceImpl;
import com.example.interviewtask.infrastructure.security.UserDetailsServiceImpl;
import com.example.interviewtask.persistence.post.PostRepositoryImpl;
import com.example.interviewtask.persistence.user.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Configuration {

    final JpaPostRepository jpaPostRepository;
    final JpaUserRepository jpaUserRepository;

    @Autowired
    public Configuration(JpaPostRepository jpaPostRepository,
                         JpaUserRepository jpaUserRepository) {
        this.jpaPostRepository = jpaPostRepository;
        this.jpaUserRepository = jpaUserRepository;
    }

    @Bean
    public PostRepositoryImpl createPostRepository() {
        return new PostRepositoryImpl(jpaPostRepository);
    }

    @Bean
    public UserRepositoryImpl createUserRepository() {
        return new UserRepositoryImpl(jpaUserRepository);
    }

    @Bean
    public CreateUserUseCase configureCreateUserUseCase(
            @Qualifier("createUserRepository") UserRepository userRepository,
            @Qualifier("configurePasswordEncoder") PasswordEncoder passwordEncoder) {
        return new CreateUserUseCase(userRepository, passwordEncoder);
    }

    @Bean
    public DateTimeServiceImpl createDateTimeService() {
        return new DateTimeServiceImpl();
    }

    @Bean
    public CreatePostUseCase configureCreatePostUseCase(
            @Qualifier("createPostRepository") PostRepository postRepository,
            @Qualifier("createUserRepository") UserRepository userRepository,
            @Qualifier("createDateTimeService") DateTimeService dateTimeService) {
        return new CreatePostUseCase(postRepository, userRepository,
                dateTimeService);
    }

    @Bean
    public GetAllPostsUseCase configureGetAllPostsUseCase(
            @Qualifier("createPostRepository") PostRepository postRepository) {
        return new GetAllPostsUseCase(postRepository);
    }

    @Bean
    public GetPostByIdUseCase configureGetPostByIdUseCase(
            @Qualifier("createPostRepository") PostRepository postRepository) {
        return new GetPostByIdUseCase(postRepository);
    }

    @Bean
    public UpdatePostUseCase configureUpdatePostUseCase(
            @Qualifier("createPostRepository") PostRepository postRepository) {
        return new UpdatePostUseCase(postRepository);
    }

    @Bean
    public UserDetailsServiceImpl configureUserDetailsService(
            @Qualifier("createUserRepository") UserRepository userRepository) {
        return new UserDetailsServiceImpl(userRepository);
    }
}
