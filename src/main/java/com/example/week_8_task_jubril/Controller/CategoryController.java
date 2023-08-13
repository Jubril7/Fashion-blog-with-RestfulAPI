package com.example.week_8_task_jubril.Controller;

import com.example.week_8_task_jubril.DTO.CategoryDTO;
import com.example.week_8_task_jubril.Model.Category;
import com.example.week_8_task_jubril.Services.ServiceImpl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/category/")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    //Post categories
    @PostMapping("save-categories")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDTO categoryDTO) {
        Category savedCategory = categoryService.saveCategory(categoryDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(savedCategory);
    }

    @GetMapping("get-all-categories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(CategoryDTO categoryDTO) {
        List<CategoryDTO> categories = categoryService.findAllCategories(categoryDTO);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category categoryDTO = categoryService.findCategoryById(id);
        return ResponseEntity.ok(categoryDTO);
    }

    @PutMapping ("update-category/{id}")
    public ResponseEntity<CategoryDTO> updateCate(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO updatedCate = categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok(updatedCate);
    }

    @DeleteMapping ("delete-category/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        String message = "Delete Success";
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(message);
    }



}
