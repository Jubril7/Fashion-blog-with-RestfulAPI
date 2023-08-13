package com.example.week_8_task_jubril.DTO;

import com.example.week_8_task_jubril.Model.Comment;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DesignDTO {
    private String designName;
    private String designDescription;
    private Double designPrice;
    private Long categoryId;
    private long likes;
    private List<Comment> commentSet = new ArrayList<>();

}
