package com.example.interviewtask.infrastructure.database.user;

import com.example.interviewtask.domain.token.Token;
import com.example.interviewtask.infrastructure.database.post.PostDataMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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
    @Length(min = 1, max = 20)
    private String firstname;
    @Column(nullable = false)
    @Length(min = 1, max = 20)
    private String lastname;
    @Column(nullable = false)
    @Length(max = 320)
    private String email;
    @Column(nullable = false)
    @Length(min = 8, max = 60)
    private String password;
    private boolean isPremium;

    @OneToMany(mappedBy = "author")
    private List<PostDataMapper> posts;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;
}