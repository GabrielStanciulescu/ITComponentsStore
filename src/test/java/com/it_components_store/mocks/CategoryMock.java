package com.it_components_store.mocks;

import com.it_components_store.entity.Category;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryMock {
    public static Category getOneCategory() {
        return Category.builder().idCategory(1L).name("Mouse").build();
    }

    public static List<Category> categoryList() {
        return List.of(
                Category.builder().idCategory(1L).name("Mouse").build(),
                Category.builder().idCategory(2L).name("SSD").build(),
                Category.builder().idCategory(3L).name("RAM").build()
        );
    }
}
