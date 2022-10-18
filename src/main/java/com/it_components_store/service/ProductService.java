package com.it_components_store.service;

import com.it_components_store.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void adProduct(ProductDto productDto);
    Optional<ProductDto> getProductById(Long id);
    List<ProductDto> getListOfProduct();
    void deleteProductById(Long id);
}
