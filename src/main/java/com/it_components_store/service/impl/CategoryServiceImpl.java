package com.it_components_store.service.impl;

import com.it_components_store.entity.Category;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.exception.InvalidDataException;
import com.it_components_store.repository.CategoryRepository;
import com.it_components_store.service.CategoryService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void addCategory(Category category) {
        if (category == null) {
            throw new DataNotFoundException("Category not found!");
        } else {
            categoryRepository.save(category);
        }
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        if (id < 0) {
            throw new InvalidDataException(String.format("Category with id %s is invalid", id));
        }
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new DataNotFoundException(String.format("Category with id %s is not present in database", id));
        } else {
            return optionalCategory;
        }
    }

    @Override
    public List<Category> getListOfCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        if (categoryList.isEmpty()) {
            throw new DataNotFoundException("Category list it's empty"); // this should not exist
        } else {
            return categoryList;
        }
    }

    @Override
    public void deleteCategoryById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (id < 0) {
            throw new InvalidDataException(String.format("Category id %s it's not valid, pleas try again with id >= 0", id));
        }
        if (categoryOptional.isEmpty()) {
            throw new DataNotFoundException(String.format("Category with id %s is not present in database", id));
        }
        categoryRepository.deleteById(id);
    }
}
