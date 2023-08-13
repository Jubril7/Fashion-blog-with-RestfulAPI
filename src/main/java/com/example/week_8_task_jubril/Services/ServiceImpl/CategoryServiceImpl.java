package com.example.week_8_task_jubril.Services.ServiceImpl;

import com.example.week_8_task_jubril.DTO.CategoryDTO;
import com.example.week_8_task_jubril.Model.Category;
import com.example.week_8_task_jubril.Repository.CategoryRepo;
import com.example.week_8_task_jubril.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category saveCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO);
        return categoryRepo.save(category);
    }

    @Override
    public List<CategoryDTO> findAllCategories(CategoryDTO categoryDTO) {
        List<Category> allCategories = categoryRepo.findAll();
        return allCategories.stream().map(this::mapCategoryToDTO).toList();

    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepo.findById(id).orElseThrow(()-> new NullPointerException("User Not found with ID: "+id));

    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category oldCategory = findCategoryById(id);
        mapDTOtoCategory(oldCategory, categoryDTO);
        Category updatedCategory = categoryRepo.save(oldCategory);
        return mapCategoryToDTO(updatedCategory);

    }

    @Override
    public void deleteCategory(Long id) {
        Category category = findCategoryById(id);
        categoryRepo.delete(category);
    }

    private CategoryDTO mapCategoryToDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setCategoryColor(category.getCategoryColor());
        categoryDTO.setCategoryDescription(category.getCategoryDescription());
        return categoryDTO;
    }

    private void mapDTOtoCategory(Category category, CategoryDTO categoryDTO) {
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setCategoryColor(categoryDTO.getCategoryColor());
        category.setCategoryDescription(categoryDTO.getCategoryDescription());
    }
}
