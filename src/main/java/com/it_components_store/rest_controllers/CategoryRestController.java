package com.it_components_store.rest_controllers;

import com.it_components_store.entity.Category;
import com.it_components_store.service.CategoryService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryRestController {

    private final CategoryService categoryService;

    @PostMapping()
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }
    @GetMapping("/{id}")
    Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
    @GetMapping("/all")
    List<Category> getAllCategories() {
        return categoryService.getListOfCategory();
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
    }
}
