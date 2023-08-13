package com.example.week_8_task_jubril.DTO;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private String categoryName;
    private String categoryColor;
    private String categoryDescription;
}
