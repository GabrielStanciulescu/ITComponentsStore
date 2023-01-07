package com.it_components_store.service.impl;

import com.it_components_store.dto.ProductDto;
import com.it_components_store.entity.Product;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.exception.InvalidDataException;
import com.it_components_store.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.it_components_store.mocks.ProductMock.getListOfProduct;
import static com.it_components_store.mocks.ProductMock.getOneProduct;
import static com.it_components_store.mocks.ProductMockDto.getListOfProductDto;
import static com.it_components_store.mocks.ProductMockDto.getOneProductDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @InjectMocks
    ProductServiceImpl productService;

    @Spy
     ModelMapper modelMapper;

    @Mock
    ProductRepository productRepository;

    @Captor
    ArgumentCaptor<Product> productArgumentCaptor;

    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;


    @Test
    @DisplayName("Test add product")
    void addProductTest() {
        ProductDto productDto = getOneProductDto();
        productService.addProduct(productDto);
        verify(productRepository).save(productArgumentCaptor.capture());
        assertEquals(getOneProduct(),productArgumentCaptor.getValue());
    }

    @Test
    @DisplayName("Test throw DataNotFoundException exception at add product")
    void throwExceptionAddProduct(){
        Exception exception  = assertThrows(DataNotFoundException.class,()->productService.addProduct(null));
        String expected = "Product not found!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test get product")
    void testGetProduct(){
        when(productRepository.findById(1L)).thenReturn(Optional.of(getOneProduct()));
        Optional<ProductDto> optionalProduct = productService.getProductById(1L);
        if(optionalProduct.isPresent()){
            ProductDto product = optionalProduct.get();
            assertEquals(getOneProductDto(),product);

        }
    }

    @Test
    @DisplayName("Test get product throw InvalidDataException")
    void testThrowInvalidDataExceptionGetProduct(){
        Exception exception = assertThrows(InvalidDataException.class,()->productService.getProductById(-1L));
        String expected = "Your id -1 it's not valid";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test get product throw DataNotFoundException")
    void testThrowDataNotFoundExceptionGetProduct(){
        when(productRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(DataNotFoundException.class,()->productService.getProductById(1L));
        String expected = "The product with id 1 does not exist!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Test getListOfPRoduct")
    void  testGetListOfProduct(){
        when(productRepository.findAll()).thenReturn(getListOfProduct());
        List<ProductDto> productList = productService.getListOfProduct();
        assertEquals( getListOfProductDto(),productList);
    }

    @Test
    @DisplayName("Test throw DataNotFoundException at list of product ")
    void testThrowDataNotFoundExceptionListOfProduct(){
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
        Exception exception = assertThrows(DataNotFoundException.class,()->productService.getListOfProduct());
        String expected = "Product list it's empty";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test delete product")
    void deleteProductTest(){
        when(productRepository.findById(1L)).thenReturn(Optional.of(getOneProduct()));
        productService.deleteProductById(1L);
         verify(productRepository,times(1)).deleteById(longArgumentCaptor.capture());
        assertEquals(1L,longArgumentCaptor.getValue());

    }

    @Test
    @DisplayName("Test throw InvalidDataException delete product")
    void testThrowInvalidDataExceptionDeleteProduct(){
        Exception exception = assertThrows(InvalidDataException.class,()->productService.deleteProductById(-1L));
        String expected = "Your id -1 it's not valid, please try again with id >=0";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Test throw DataNotFoundException delete product")
    void testThrowDataNotFoundExceptionDeleteProduct(){
        when(productRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(DataNotFoundException.class,()->productService.deleteProductById(1L));
        String expected = "Category with id 1 it's not present in database";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test update product")
    void testUpdateProduct(){


    }
}