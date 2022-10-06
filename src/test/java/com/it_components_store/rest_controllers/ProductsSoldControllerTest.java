package com.it_components_store.rest_controllers;

import com.it_components_store.entity.SoldProducts;
import com.it_components_store.service.ProductService;
import com.it_components_store.service.ProductsSoldService;
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

import static com.it_components_store.mocks.ProductMock.getOneProduct;
import static com.it_components_store.mocks.ProductSoldMock.getListOfProductsSold;
import static com.it_components_store.mocks.ProductSoldMock.getOneProductsSold;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ProductsSoldControllerTest {
    @InjectMocks
    ProductsSoldController productsSoldController;

    @Mock
    ProductsSoldService productSoldService;

    @Mock
    ProductService productService;

    @Captor
    ArgumentCaptor<SoldProducts> soldProductsArgumentCaptor;

    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;

    @Test
    @DisplayName("Test add productSold")
    void addProductsSold() {
        when(productService.getProductById(1L)).thenReturn(Optional.of(getOneProduct()));
        SoldProducts soldProducts = getOneProductsSold();
        productsSoldController.addProductsSold(soldProducts,1L);
        verify(productSoldService,times(1)).addProductsSold(soldProductsArgumentCaptor.capture());
        assertEquals(getOneProductsSold(),soldProductsArgumentCaptor.getValue());

    }

    @Test
    @DisplayName("Test get sold product by name")
    void testGetProductSoldByName() {
        when(productSoldService.getProductsSoldById(1L)).thenReturn(Optional.of(getOneProductsSold()));
        Optional<SoldProducts> productOptional = productsSoldController.getProductsSoldById(1L);
        if (productOptional.isPresent()) {
            SoldProducts SoldProducts = productOptional.get();
            assertEquals(getOneProductsSold(), SoldProducts);
        }
    }

    @Test
    @DisplayName("Test get all sold product")
    void testGetAllSoldProduct() {
        when(productSoldService.listOfProductsSold()).thenReturn(getListOfProductsSold());
        List<SoldProducts> soldProductsList = productsSoldController.getAllProductsSold();
        assertEquals(getListOfProductsSold(), soldProductsList);
    }

    @Test
    @DisplayName("Test delete sold product")
    void testDeleteSoldProduct() {
        productsSoldController.deleteById(1L);
        verify(productSoldService, times(1)).deleteProductsSoldById(longArgumentCaptor.capture());
        assertEquals(1, longArgumentCaptor.getValue());
    }

}