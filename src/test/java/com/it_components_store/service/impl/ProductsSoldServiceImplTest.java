package com.it_components_store.service.impl;

import com.it_components_store.entity.SoldProducts;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.exception.InvalidDataException;
import com.it_components_store.repository.ProductsSoldRepository;
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

import static com.it_components_store.mocks.ProductSoldMock.getListOfProductsSold;
import static com.it_components_store.mocks.ProductSoldMock.getOneProductsSold;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductsSoldServiceImplTest {
    @InjectMocks
    ProductsSoldServiceImpl productsSoldService;
    @Mock
    ProductsSoldRepository productsSoldRepository;
    @Captor
    ArgumentCaptor<SoldProducts> productsSoldArgumentCaptor;
    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;

    @Test
    @DisplayName("Test add product sold ")
    void testAddProductsSold() {
        SoldProducts productsSold = getOneProductsSold();
        productsSoldService.addProductsSold(productsSold);
        verify(productsSoldRepository,times(1)).save(productsSoldArgumentCaptor.capture());
        assertEquals(productsSold,productsSoldArgumentCaptor.getValue());
    }

    @Test
    @DisplayName("Test throw DataNotFoundException")
    void testThrowDataNotFoundException(){
        Exception exception = assertThrows(DataNotFoundException.class,()->productsSoldService.addProductsSold(null));
        String expected = "Error! SoldProducts not found!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test get product sold")
    void testGetProductSoldByID(){
        when(productsSoldRepository.findById(1L)).thenReturn(Optional.of(getOneProductsSold()));
        Optional<SoldProducts> productsSold = productsSoldService.getProductsSoldById(1L);
        if(productsSold.isPresent()) {
            SoldProducts productsSold1 = productsSold.get();
            assertEquals(getOneProductsSold(), productsSold1);
        }
    }

    @Test
    @DisplayName("Test throw InvalidDataException get product by id  ")
    void testInvalidDataExceptionGetProduct(){
        Exception exception = assertThrows(InvalidDataException.class,()->productsSoldService.getProductsSoldById(-1L));
        String expected  = "Error! Your id -1 it's not valid";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test throw DataNotFoundException get product")
    void testThrowDataNotFoundExceptionGetProduct(){
        when(productsSoldRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(DataNotFoundException.class,()->productsSoldService.getProductsSoldById(1L));
        String expected  = "Error! The products sold with  id 1 does not exist!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Test  get list of product sold")
    void testGetListOfProductSold(){
        when(productsSoldRepository.findAll()).thenReturn(getListOfProductsSold());
        List<SoldProducts> productsSoldList  = productsSoldService.listOfProductsSold();
        assertEquals(getListOfProductsSold(),productsSoldList);
    }

    @Test
    @DisplayName("Test throw DataNotFoundException  at list of product sold")
    void testThrowDataNotFoundExceptionGet(){
        Exception exception = assertThrows(DataNotFoundException.class,()->productsSoldService.listOfProductsSold());
        String expected  = "Error! productsSold list it's empty";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test delete Product sold")
    void testProductSold(){
        when(productsSoldRepository.findById(1L)).thenReturn(Optional.of(getOneProductsSold()));
        productsSoldService.deleteProductsSoldById(1L);
        verify(productsSoldRepository,times(1)).deleteById(longArgumentCaptor.capture());
        assertEquals(1,longArgumentCaptor.getValue());
    }

    @Test
    @DisplayName("Test throw InvalidDataException delete by id")
    void testThrowInvalidDataExceptionDeleteByID(){
        when(productsSoldRepository.findById(-1L)).thenReturn(Optional.of(getOneProductsSold()));
        Exception exception = assertThrows(InvalidDataException.class,()->productsSoldService.deleteProductsSoldById(-1L));
        String expected  = "Error! Your id -1 it's not valid, pleas try again with id >=0";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test throw InvalidDataException delete by id")
    void testThrowDataNotFoundExceptionDeleteByID(){
        when(productsSoldRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(DataNotFoundException.class,()->productsSoldService.deleteProductsSoldById(1L));
        String expected  = "Error  Product with id 1 it's not present in database";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }
}