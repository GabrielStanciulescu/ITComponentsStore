package com.ITComponentsStore.Service.impl;

import com.ITComponentsStore.Entity.Category;
import com.ITComponentsStore.Exception.DataNotFoundException;
import com.ITComponentsStore.Exception.InvalidDataException;
import com.ITComponentsStore.Repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.ITComponentsStore.Mocks.CategoryMock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {
    @InjectMocks
    CategoryServiceImpl categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Captor
    ArgumentCaptor<Category> categoryArgumentCaptor;

    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;

    @Test
    @DisplayName("Testing add Categort")
    void addCategoryTest() {
        Category category = getOneCategory();
        categoryService.addCategory(category);
        verify(categoryRepository,times(1)).save(categoryArgumentCaptor.capture());
        assertEquals(category, categoryArgumentCaptor.getValue());
    }
    @Test
    @DisplayName("Testing throw exception add category")
    void testThrowAddCategory(){
        Exception exception = assertThrows(DataNotFoundException.class,()->categoryService.addCategory(null));
        String expected = "Error Category not found!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Test category by id")
    void testGetCategoryById(){
       when(categoryRepository.findById(1L)).thenReturn(Optional.of(getOneCategory()));
       Optional<Category>categoryOptional = categoryService.getCategoryById(1L);
       if (categoryOptional.isPresent()){
           Category category = categoryOptional.get();
           assertEquals(getOneCategory(),category);

       }


    }

    @Test
    @DisplayName("Test exception getCategory by Name InvalidDataException because id it-s <0")
    void testThrowGetCategoryByID(){
        Exception exception = assertThrows(InvalidDataException.class,()->categoryService.getCategoryById(-1L));
        String expected = "Error! Your id -1 it's not valid";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test exception DataNotFoundException getCategory by " )
    void testThrowGetCategoryById(){
        when(categoryRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(DataNotFoundException.class,()->categoryService.getCategoryById(1L));
        String expected  = "Error! The category with id 1 does not exist!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("test get list of category")
    void testGetListOfCategory(){
        when(categoryRepository.findAll()).thenReturn(categoryList());
        List<Category> categoryList = categoryService.getListOfCategory();
        assertEquals(categoryList(),categoryList);
    }

    @Test
    @DisplayName("Test throw exception get list of category")
    void testThrowGetListOdCategory(){
        when(categoryRepository.findAll()).thenReturn(Collections.emptyList());
        Exception exception = assertThrows(DataNotFoundException.class,()->categoryService.getListOfCategory());
        String expected  = "Error! Category list it's empty";
        String actual = exception.getMessage();
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Test delete")
    void testDelete(){
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(getOneCategory()));
       categoryService.deleteCategoryById(1L);
       verify(categoryRepository,times(1)).deleteById(longArgumentCaptor.capture());
       assertEquals(1L,longArgumentCaptor.getValue());

    }
    @Test
    @DisplayName("Test throw InvalidDataException exception ")
    void testThrowDelete(){
        Exception exception = assertThrows(InvalidDataException.class,()->categoryService.deleteCategoryById(-1L));
        String expected  = "Error! Your id -1 it's not valid, pleas try again with id >=0";
        String actual = exception.getMessage();
        assertEquals(expected,actual);


    }
    @Test
    @DisplayName("Test throw DataNotFoundException exception ")
    void testThrowDeleteEmptyDb(){

        Exception exception = assertThrows(DataNotFoundException.class,()->categoryService.deleteCategoryById(1L));
        String expected  = "Error Category with id 1 it's not present in database";
        String actual = exception.getMessage();
        assertEquals(expected,actual);

    }

}