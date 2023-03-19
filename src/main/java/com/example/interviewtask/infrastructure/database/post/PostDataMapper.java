package com.example.interviewtask.infrastructure.database.post;

import com.example.interviewtask.infrastructure.database.user.UserDataMapper;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

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
    @Length(min = 1, max = 20)
    private String title;

    @Length(max = 250)
    private String description;
    @Column(nullable = false)
    private String content;

    @Column(name = "authorId")
    private int authorId;

    @JoinColumn(referencedColumnName = "id", insertable = false, name = "authorId", updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private UserDataMapper author;
    @Column(nullable = false)
    private LocalDateTime publishDate;

    private boolean isPremium;
}
