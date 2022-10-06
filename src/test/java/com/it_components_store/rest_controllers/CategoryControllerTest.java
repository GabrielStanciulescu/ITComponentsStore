package com.it_components_store.rest_controllers;

import com.it_components_store.entity.Category;
import com.it_components_store.service.CategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static com.it_components_store.mocks.CategoryMock.categoryList;
import static com.it_components_store.mocks.CategoryMock.getOneCategory;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {
    @InjectMocks
    CategoryController categoryController;

    @Mock
    CategoryService categoryService;

    @Captor
    ArgumentCaptor<Category> categoryArgumentCaptor;

    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;

    @Test
    @DisplayName("Test add category")
    void addCategory() {
        Category category = getOneCategory();
        categoryController.addCategory(category);
        verify(categoryService, times(1)).addCategory(categoryArgumentCaptor.capture());
        assertEquals(category, categoryArgumentCaptor.getValue());
    }

    @Test
    @DisplayName("Test get category by name")
    void testGetCategoryByName() {
        when(categoryService.getCategoryById(1L)).thenReturn(Optional.of(getOneCategory()));
        Optional<Category> categoryOptional = categoryController.getCategoryById(1L);
        if(categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            assertEquals(getOneCategory(), category);
        }
    }

    @Test
    @DisplayName("Test get all Category")
    void testGetAllCategory(){
        when(categoryService.getListOfCategory()).thenReturn(categoryList());
        List<Category> categoryList = categoryController.getAllCategories();
        assertEquals(categoryList(), categoryList);
    }

    @Test
    @DisplayName("Test delete category")
    void testDeleteCategory(){
        categoryController.deleteById(1L);
        verify(categoryService,times(1)).deleteCategoryById(longArgumentCaptor.capture());
        assertEquals(1, longArgumentCaptor.getValue());
    }
}
