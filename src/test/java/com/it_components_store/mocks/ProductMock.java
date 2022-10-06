package com.it_components_store.mocks;

import com.it_components_store.entity.Category;
import com.it_components_store.entity.Product;

import java.util.List;

public class ProductMock {
    public static Product getOneProduct(){
        Category category = new Category(1L,"Mouse");
        return   new   Product(1L,"mouse",23456,200,"Mouse gaming","pokmn85",category);

    }

    public static List<Product> getListOfProduct(){
        Category category = new Category(1L,"Mouse");
        Product product = new Product(1L,"mouse",23456,200,"Mouse gaming","pokmn85",category);
        Product product2 = new Product(2L,"mouse",23456,200,"Mouse gaming","pokmn85",category);
        Product product3 = new Product(3L,"mouse",23456,200,"Mouse gaming","pokmn85",category);

        return List.of(product,product2,product3);

    }
}
