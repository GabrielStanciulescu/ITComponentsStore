package com.ITComponentsStore.Mocks;

import com.ITComponentsStore.Entity.Category;

import java.util.List;

public class CategoryMock {

    public static List<Category> categoryList(){
        Category category = new Category(1L,"Mouse");
        Category category2 = new Category(2L,"SSD");
        Category category3 = new Category(3L,"RAM");
        return List.of(category,category2,category3);
    }


    public static Category getOneCategory(){
        return new Category(1L,"Mouse");
    }
}
