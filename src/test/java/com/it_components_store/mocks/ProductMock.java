package com.it_components_store.mocks;

import com.it_components_store.entity.Category;
import com.it_components_store.entity.Product;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductMock {
    public static Product getOneProduct() {
        Category category = Category.builder().idCategory(1L).name("Mouse").build();
        return Product.builder().idProduct(1L).name("mouse").stock(23456).price(200).description("Mouse gaming").code("pokmn85").category(category).build();

    }

    public static List<Product> getListOfProduct() {
        Category category = Category.builder().idCategory(1L).name("Mouse").build();
        return List.of(
                Product.builder().idProduct(1L).name("mouse").stock(23456).price(200).description("Mouse gaming").code("pokmn85").category(category).build(),
                Product.builder().idProduct(1L).name("mouse").stock(23456).price(200).description("Mouse gaming").code("pokmn85").category(category).build(),
                Product.builder().idProduct(1L).name("mouse").stock(23456).price(200).description("Mouse gaming").code("pokmn85").category(category).build()
        );
    }
}
