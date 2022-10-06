package com.it_components_store.service;

import com.it_components_store.entity.SoldProducts;

import java.util.List;
import java.util.Optional;

public interface ProductsSoldService {
    void addProductsSold(SoldProducts productsSold);
    Optional<SoldProducts> getProductsSoldById(Long id);
    List<SoldProducts> listOfProductsSold();
    void deleteProductsSoldById(Long id);
}
