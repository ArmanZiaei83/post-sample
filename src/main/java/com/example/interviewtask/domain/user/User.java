package com.example.interviewtask.domain.user;

import com.example.interviewtask.domain.token.Token;
import com.example.interviewtask.infrastructure.database.post.PostDataMapper;
import com.example.interviewtask.infrastructure.database.user.Role;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private boolean isPremium;

    private List<PostDataMapper> posts;

    private Role role;

    private List<Token> tokens;
}