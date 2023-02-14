package com.it_components_store.service.impl;

import com.it_components_store.dto.ShoppingCartDto;
import com.it_components_store.entity.ShoppingCart;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.exception.InvalidDataException;
import com.it_components_store.repository.ShoppingCartRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static com.it_components_store.mocks.MocksDto.ShoppingCartMockDto.getListOfShoppingCartDTO;
import static com.it_components_store.mocks.MocksDto.ShoppingCartMockDto.getOneShoppingCartDto;
import static com.it_components_store.mocks.ShoppingCartMock.getListOfShoppingCart;
import static com.it_components_store.mocks.ShoppingCartMock.getOneShoppingCart;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShoppingCartServiceImplTest {
    @InjectMocks
    ShoppingCartServiceImpl shoppingCartService;
    @Mock
    ShoppingCartRepository shoppingCartRepository;
    @Captor
    ArgumentCaptor<ShoppingCart> shoppingCartArgumentCaptor;
    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;
    @Spy
    ModelMapper modelMapper;


    @Test
    @DisplayName("Test Method  addShoppingCart()")
    void testAddShoppingCart() {
        ShoppingCartDto shoppingCartDto = getOneShoppingCartDto();
        shoppingCartService.addShoppingCart(shoppingCartDto);
        verify(shoppingCartRepository).save(shoppingCartArgumentCaptor.capture());
        assertEquals(getOneShoppingCart().toString(), shoppingCartArgumentCaptor.getValue().toString());

    }
    @Test
    @DisplayName("Test Exception for method addShoppingCart ")
    void testThrowExceptionAddShoppingCart(){
        Exception exception = assertThrows(DataNotFoundException.class, ()->shoppingCartService.addShoppingCart(null));
        String expected = "Product not found!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);


    }
    @Test
    @DisplayName("Test for method getShoppingCartById  ")
    void testGetShoppingCartById(){
        when(shoppingCartRepository.findById(1L)).thenReturn(Optional.of(getOneShoppingCart()));
        Optional<ShoppingCartDto> shoppingCartDto = shoppingCartService.getShoppingCartById(1L);
        assertEquals(getOneShoppingCartDto(), shoppingCartDto.get());
    }
    @Test
    @DisplayName("Test throw InvalidDataException for getShoppingCartById ")
    void testThrowInvalidDataExceptionGetShoppingCartById(){

        Exception exception = assertThrows(InvalidDataException.class, ()->shoppingCartService.getShoppingCartById(-1L));
        String expected = "Your id -1 it's not valid";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test throw DataNotFoundException for getShoppingCartById")
    void testThrowDataNotFoundExceptionGetShoppingCartById(){
        Exception exception = assertThrows(DataNotFoundException.class, ()->shoppingCartService.getShoppingCartById(1L));
        String expected = "Error! The product with id 1 does not exist!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test method deleteShoppingCartById ")
    void testDeleteShoppingCartById(){
        when(shoppingCartRepository.findById(1L)).thenReturn(Optional.of(getOneShoppingCart()));
        shoppingCartService.deleteShoppingCartById(1L);
        verify(shoppingCartRepository).deleteById(longArgumentCaptor.capture());
        assertEquals(1L, longArgumentCaptor.getValue());
    }
    @Test
    @DisplayName("Test throw DataNotFoundException for deleteShoppingCartById")
    void testThrowDataNotFoundExceptionDeleteShoppingCartById(){

        Exception exception = assertThrows(DataNotFoundException.class, ()->shoppingCartService.deleteShoppingCartById(1L));
        String expected = "Category with id 1 it's not present in database";
        String actual = exception.getMessage();
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Test throw InvalidDataException for deleteShoppingCartById ")
    void testThrowInvalidDataExceptionDeleteShoppingCartById(){
        Exception exception = assertThrows(InvalidDataException.class, ()->shoppingCartService.deleteShoppingCartById(-1L));
        String expected = "Your id -1 it's not valid, please try again with id >=0";
        String actual = exception.getMessage();
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Test method deleteShoppingCartById ")
    void testDeleteByIdUser(){
        shoppingCartService.deleteByIdUser(1L);
        verify(shoppingCartRepository).deleteShoppingCartByIdUser(longArgumentCaptor.capture());
        assertEquals(1L, longArgumentCaptor.getValue());
    }
    @Test
    @DisplayName("Test method getListOfShoppingCartByUserId")
    void testGetListOfShoppingCartByUserId(){
        when(shoppingCartRepository.getShoppingCartByIdUser(1L)).thenReturn(getListOfShoppingCart());
        List<ShoppingCartDto> shoppingCartList = shoppingCartService.getListOfShoppingCartByUserId(1L);
        assertEquals(getListOfShoppingCartDTO(), shoppingCartList);


    }
    @Test
    @DisplayName("Test throw DataNotFoundException for getListOfShoppingCartByUserId ")
    void testThrowDataNotFoundExceptionGetListOfShoppingCartByUserId(){
        Exception exception = assertThrows(DataNotFoundException.class, ()->shoppingCartService. getListOfShoppingCartByUserId(1L));
        String expected = "Product list it's empty";
        String actual = exception.getMessage();
        assertEquals(expected,actual);


    }



}