package com.example.week_8_task_jubril.Model;

import com.example.week_8_task_jubril.DTO.CategoryDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(nullable = false)
    private String categoryName;
    @Column(nullable = false)
    private String categoryColor;
    @Column(nullable = false)
    private String categoryDescription;

    public Category(CategoryDTO categoryDTO) {
        this.categoryName = categoryDTO.getCategoryName();
        this.categoryColor = categoryDTO.getCategoryColor();
        this.categoryDescription = categoryDTO.getCategoryDescription();
    }
}
