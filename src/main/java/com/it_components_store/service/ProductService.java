package com.it_components_store.service;

import com.it_components_store.dto.ProductDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void addProduct(ProductDto productDto);
    Optional<ProductDto> getProductById(Long id);
    List<ProductDto> getListOfProduct();
    void deleteProductById(Long id);
    void updateProduct(ProductDto productDto, Long id);
    List<ProductDto> getListOfProductsByCategory(Long id);
    List<ProductDto> getProductByDescription(String description);
    Page<ProductDto> getProductPagination(int currentPage, int size);
    Integer getTotalNumberOfPage(int currentPage, int size);
    Long getTotalNumberOfElements(int currentPage, int size);
    Integer getTotalNumberOfPageByCategory(Long id, int currentPage, int size);
    Long getTotalNumberOfElementsByCategory(Long id, int currentPage, int size);

    Page<ProductDto> getAllProductByCategory(Long id, int currentPage, int size);


}
