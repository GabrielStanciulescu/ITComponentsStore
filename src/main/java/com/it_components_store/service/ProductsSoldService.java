package com.it_components_store.service;

import com.it_components_store.entity.ProductsSold;

import java.util.List;
import java.util.Optional;

public interface ProductsSoldService {
    void addProductsSold(ProductsSold productsSold);
    Optional<ProductsSold> getProductsSoldById(Long id);
    List<ProductsSold> listOfProductsSold();
    void deleteProductsSoldById(Long id);
}
