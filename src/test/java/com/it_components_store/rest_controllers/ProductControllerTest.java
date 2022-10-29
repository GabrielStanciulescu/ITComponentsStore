package com.it_components_store.rest_controllers;

import com.it_components_store.dto.ProductDto;
import com.it_components_store.service.impl.ProductServiceImpl;
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

import static com.it_components_store.mocks.ProductMockDto.getListOfProductDto;
import static com.it_components_store.mocks.ProductMockDto.getOneProductDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @InjectMocks
    ProductController productController;

    @Mock
    ProductServiceImpl productService;


    @Captor
    ArgumentCaptor<ProductDto> productArgumentCaptor;

    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;


    @Test
    @DisplayName("Test add product")
    void testAddProduct() {
        ProductDto product = getOneProductDto();
        productController.addProduct(product);
        verify(productService, times(1)).addProduct(productArgumentCaptor.capture());
        assertEquals(getOneProductDto(), productArgumentCaptor.getValue());


    }

    @Test
    @DisplayName("Test get product by name")
    void testGetProductByName() {
        when(productService.getProductById(1L)).thenReturn(Optional.of(getOneProductDto()));
        Optional<ProductDto> productOptional = productController.getProductById(1L);
        if (productOptional.isPresent()) {
            ProductDto product = productOptional.get();
            assertEquals(getOneProductDto(), product);
        }
    }

    @Test
    @DisplayName("Test get all product")
    void testGetAllProduct() {
        when(productService.getListOfProduct()).thenReturn(getListOfProductDto());
        List<ProductDto> productList = productController.getAllProduct();
        assertEquals(getListOfProductDto(), productList);
    }

    @Test
    @DisplayName("Test delete product")
    void testDeleteProduct() {
        productController.deleteById(1L);
        verify(productService, times(1)).deleteProductById(longArgumentCaptor.capture());
        assertEquals(1, longArgumentCaptor.getValue());
    }
}