package com.it_components_store.mocks;

import com.it_components_store.entity.SoldProducts;
import com.it_components_store.entity.Category;
import com.it_components_store.entity.Product;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductSoldMock {
    public static SoldProducts getOneProductsSold() {
        Category category = Category.builder().idCategory(1L).name("Mouse").build();
        Product product = Product.builder().idProduct(1L).name("mouse").price(23456).stock(200).description("Mouse gaming").code("pokmn85").category(category).build();
        return SoldProducts.builder().idSoldProducts(1L).quantity(200).products(List.of(product)).build();
    }

    public static List<SoldProducts> getListOfProductsSold() {
        Category category = Category.builder().idCategory(1L).name("Mouse").build();
        Product product = Product.builder().idProduct(1L).name("mouse").price(23456).stock(200).description("Mouse gaming").code("pokmn85").category(category).build();
        return List.of(
                SoldProducts.builder().idSoldProducts(1L).quantity(200).products(List.of(product)).build(),
                SoldProducts.builder().idSoldProducts(1L).quantity(200).products(List.of(product)).build(),
                SoldProducts.builder().idSoldProducts(1L).quantity(200).products(List.of(product)).build()
        );
    }
}
