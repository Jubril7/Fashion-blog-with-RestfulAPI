package com.example.week_8_task_jubril.Model;

import com.example.week_8_task_jubril.DTO.CommentDTO;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Column(nullable = false, length = 2000)
    private String text;
    @JoinColumn(name = "design_id")
    private Long designId;
    private Long personId;

}
