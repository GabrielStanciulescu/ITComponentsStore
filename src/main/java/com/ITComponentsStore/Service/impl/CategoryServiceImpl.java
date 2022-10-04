package com.ITComponentsStore.Service.impl;

import com.ITComponentsStore.Entity.Category;
import com.ITComponentsStore.Entity.Users;
import com.ITComponentsStore.Exception.DataNotFoundException;
import com.ITComponentsStore.Exception.InvalidDataException;
import com.ITComponentsStore.Repository.CategoryRepository;
import com.ITComponentsStore.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public void addCategory(Category category) {
        if(category==null){
            throw new DataNotFoundException("Error Category not found!");
        }
        else {
            categoryRepository.save(category);
        }

    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        if(id<0){
            throw new InvalidDataException("Error! Your id" + id+ "it's not valid");
        }
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isEmpty()){
            throw new DataNotFoundException("Error! The category with id "+ id + "  does not exist! ");
        }
        else {
            return optionalCategory;
        }


    }

    @Override
    public List<Category> getListOfCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        if(categoryList.isEmpty()){
            throw new DataNotFoundException("Error! Category list it's empty");
        }
        else{
            return categoryList;
        }

    }

    @Override
    public void deleteCategoryById(Long id) {

        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(id<0){
            throw new InvalidDataException("Error! Your id" + id+ " it's not valid, pleas try again with id >=0");
        }
        if(categoryOptional.isEmpty()){
            throw new DataNotFoundException("Error Category with id " + id + " it's not present in database");
        }

        categoryRepository.deleteById(id);


    }
}
