package com.example.interviewtask.infrastructure.database.user;

import com.example.interviewtask.domain.token.Token;
import com.example.interviewtask.infrastructure.database.post.PostDataMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class UserDataMapper {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)

    private String lastname;
    @Column(nullable = false)

    private String email;
    @Column(nullable = false)

    private String password;
    @Column(nullable = false)

    private boolean isPremium;

    @OneToMany(mappedBy = "authorId")
    private List<PostDataMapper> posts;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;
}