package com.example.interviewtask.infrastructure.database.post;

import com.example.interviewtask.infrastructure.database.user.UserDataMapper;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class PostDataMapper {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String content;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private UserDataMapper author;
    private LocalDateTime publishDate;
    private boolean isPremium;
}
