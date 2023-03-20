package com.example.interviewtask.domain.user;

import com.example.interviewtask.infrastructure.database.post.PostDataMapper;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private boolean isPremium;

    private List<PostDataMapper> posts;

    private Role role;
}