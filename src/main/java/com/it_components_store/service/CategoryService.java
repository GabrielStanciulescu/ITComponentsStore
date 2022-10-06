package com.it_components_store.service;

import com.it_components_store.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    void addCategory(Category category);
    Optional<Category> getCategoryById(Long id);
    List<Category> getListOfCategory();
    void deleteCategoryById(Long id);
}
