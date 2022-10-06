package com.it_components_store.rest_controllers;

import com.it_components_store.entity.Product;
import com.it_components_store.service.CategoryService;
import com.it_components_store.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.it_components_store.mocks.CategoryMock.getOneCategory;
import static com.it_components_store.mocks.ProductMock.getListOfProduct;
import static com.it_components_store.mocks.ProductMock.getOneProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    @Mock
    CategoryService categoryService;

    @Captor
    ArgumentCaptor<Product> productArgumentCaptor;

    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;


    @Test
    @DisplayName("Test add product")
    void testAddProduct() {
        when(categoryService.getCategoryById(1L)).thenReturn(Optional.of(getOneCategory()));
        Product product = getOneProduct();
        productController.addProduct(product, 1L);
        verify(productService, times(1)).adProduct(productArgumentCaptor.capture());
        assertEquals(getOneProduct(), productArgumentCaptor.getValue());


    }

    @Test
    @DisplayName("Test get product by name")
    void testGetProductByName() {
        when(productService.getProductById(1L)).thenReturn(Optional.of(getOneProduct()));
        Optional<Product> productOptional = productController.getProductById(1L);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            assertEquals(getOneProduct(), product);
        }
    }

    @Test
    @DisplayName("Test get all product")
    void testGetAllProduct() {
        when(productService.getListOfProduct()).thenReturn(getListOfProduct());
        List<Product> productList = productController.getAllProduct();
        assertEquals(getListOfProduct(), productList);
    }

    @Test
    @DisplayName("Test delete product")
    void testDeleteProduct() {
        productController.deleteById(1L);
        verify(productService, times(1)).deleteProductById(longArgumentCaptor.capture());
        assertEquals(1, longArgumentCaptor.getValue());
    }
}