package com.example.interviewtask.infrastructure.database.user;

import com.example.interviewtask.domain.user.Role;
import com.example.interviewtask.infrastructure.database.post.PostDataMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserDataMapper implements UserDetails {

    @Id
    private String id;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}