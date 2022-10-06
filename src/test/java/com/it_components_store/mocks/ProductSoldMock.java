package com.it_components_store.mocks;

import com.it_components_store.entity.Category;
import com.it_components_store.entity.Product;
import com.it_components_store.entity.ProductsSold;

import java.util.List;

public class ProductSoldMock {
    public static ProductsSold getOneProductsSold(){
        Category category = new Category(1L,"Mouse");
        Product product = new Product(1L,"mouse",23456,200,"Mouse gaming","pokmn85",category);
        return new ProductsSold(1L,100, product);
    }

    public  static List<ProductsSold> getListOfProductsSold(){
        Category category = new Category(1L,"Mouse");
        Product product = new Product(1L,"mouse",23456,200,"Mouse gaming","pokmn85",category);

        return List.of(new ProductsSold(1L,100, product),
                new ProductsSold(1L,100, product),
                new ProductsSold(1L,100, product));
    }
}
