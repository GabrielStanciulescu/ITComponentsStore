package com.ITComponentsStore.Service;

import com.ITComponentsStore.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void adProduct(Product product);
    Optional<Product> getProductById(Long id);
    List<Product> getListOfProduct();
    void deleteProductById(Long id);
}
