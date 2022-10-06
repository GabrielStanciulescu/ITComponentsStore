package com.it_components_store.service.impl;
import com.it_components_store.entity.Product;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.exception.InvalidDataException;
import com.it_components_store.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static com.it_components_store.mocks.ProductMock.getListOfProduct;
import static com.it_components_store.mocks.ProductMock.getOneProduct;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @InjectMocks
    ProductServiceImpl productService;
    @Mock
    ProductRepository productRepository;

    @Captor
    ArgumentCaptor<Product> productArgumentCaptor;

    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;


    @Test
    @DisplayName("Test add product")
    void addProductTest() {
        Product product = getOneProduct();
        productService.adProduct(product);
        verify(productRepository).save(productArgumentCaptor.capture());
        assertEquals(product,productArgumentCaptor.getValue());
    }

    @Test
    @DisplayName("Test throw DataNotFoundException exception at add product")
    void throwExceptionAddProduct(){
        Exception exception  = assertThrows(DataNotFoundException.class,()->productService.adProduct(null));
        String expected = "Error! Product not found!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test get product")
    void testGetProduct(){
        when(productRepository.findById(1L)).thenReturn(Optional.of(getOneProduct()));
        Optional<Product> optionalProduct = productService.getProductById(1L);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            assertEquals(getOneProduct(),product);

        }
    }

    @Test
    @DisplayName("Test get product throw InvalidDataException")
    void testThrowInvalidDataExceptionGetProduct(){
        Exception exception = assertThrows(InvalidDataException.class,()->productService.getProductById(-1L));
        String expected = "Error! Tour id -1 it's not valid";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test get product throw DataNotFoundException")
    void testThrowDataNotFoundExceptionGetProduct(){
        when(productRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(DataNotFoundException.class,()->productService.getProductById(1L));
        String expected = "Error! The product with id 1 does not exist!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Test getListOfPRoduct")
    void  testGetListOfProduct(){
        when(productRepository.findAll()).thenReturn(getListOfProduct());
        List<Product> productList = productService.getListOfProduct();
        assertEquals( getListOfProduct(),productList);
    }

    @Test
    @DisplayName("Test throw DataNotFoundException at list of product ")
    void testThrowDataNotFoundExceptionListOfProduct(){
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
        Exception exception = assertThrows(DataNotFoundException.class,()->productService.getListOfProduct());
        String expected = "Error! Product list it's empty";
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
        String expected = "Error! Your id -1 it's not valid, please try again with id >=0";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Test throw DataNotFoundException delete product")
    void testThrowDataNotFoundExceptionDeleteProduct(){
        when(productRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(DataNotFoundException.class,()->productService.deleteProductById(1L));
        String expected = "Error Category with id 1 it's not present in database";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }
}