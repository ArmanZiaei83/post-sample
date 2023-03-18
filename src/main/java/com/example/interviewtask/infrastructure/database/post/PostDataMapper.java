package com.example.interviewtask.infrastructure.database.post;

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
    private int id;
    @Column(nullable = false)
    private String title;

    private String description;
    @Column(nullable = false)
    private String content;
    @JoinColumn(name = "authorId")
    @Column(nullable = false)
    private int authorId;
    @Column(nullable = false)
    private LocalDateTime publishDate;

    @Column(nullable = false)
    private boolean isPremium;
}
