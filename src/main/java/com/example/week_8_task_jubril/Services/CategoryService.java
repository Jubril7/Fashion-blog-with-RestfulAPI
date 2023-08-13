package com.example.week_8_task_jubril.Services;

import com.example.week_8_task_jubril.DTO.CategoryDTO;
import com.example.week_8_task_jubril.Model.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> findAllCategories(CategoryDTO categoryDTO);
    Category findCategoryById(Long id);
    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);
    void deleteCategory(Long id);

}
