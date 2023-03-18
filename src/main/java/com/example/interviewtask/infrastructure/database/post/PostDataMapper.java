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
    private String title;
    private String description;
    private String content;
    @JoinColumn(name = "authorId")
    private int authorId;
    private LocalDateTime publishDate;
    private boolean isPremium;
}
