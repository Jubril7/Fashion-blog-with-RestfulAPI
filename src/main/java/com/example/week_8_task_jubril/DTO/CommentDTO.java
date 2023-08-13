package com.example.week_8_task_jubril.DTO;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
    private Long commentId;
    private String text;
}
