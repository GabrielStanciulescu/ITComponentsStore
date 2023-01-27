package com.it_components_store.service.impl;

import com.it_components_store.dto.CheckoutProductDto;
import com.it_components_store.entity.CheckoutProduct;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.repository.CheckoutProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;

import static com.it_components_store.mocks.CheckoutProductMock.getListOfCheckout;
import static com.it_components_store.mocks.CheckoutProductMock.getOneCheckout;
import static com.it_components_store.mocks.MocksDto.CheckoutProductMockDto.getListOfCheckoutDto;
import static com.it_components_store.mocks.MocksDto.CheckoutProductMockDto.getOneCheckoutDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CheckoutProductServiceImplTest {

    @InjectMocks
    CheckoutProductServiceImpl checkoutProductService;

    @Spy
    ModelMapper modelMapper;

    @Mock
    CheckoutProductRepository checkoutProductRepository;

    @Captor
    ArgumentCaptor<CheckoutProduct> checkoutProductArgumentCaptor;


    @Test
    @DisplayName("Add Checkout Product")
    void addCheckoutProduct() {
        CheckoutProductDto checkoutProductDto = getOneCheckoutDto();
        checkoutProductService.addCheckoutProduct(checkoutProductDto);
        verify(checkoutProductRepository).save(checkoutProductArgumentCaptor.capture());
        assertEquals(checkoutProductArgumentCaptor.getValue().toString(), getOneCheckout().toString());

    }

    @Test
    @DisplayName("Throw error addCheckoutProduct ")
    void testThrowAddCheckoutProduct() {
        Exception exception = assertThrows(DataNotFoundException.class, () -> checkoutProductService.addCheckoutProduct(null));
        String expected = "Order not found!";
        String actual = exception.getMessage();
        assertEquals(expected, actual);


    }

    @Test()
    @DisplayName("Test method listOfCheckoutProductDto")
    void testListOfCheckoutProductDto() {
        when(checkoutProductRepository.findAll()).thenReturn(getListOfCheckout());
        List<CheckoutProductDto> checkoutProductDtoList = checkoutProductService.listOfCheckoutProductDto();
        assertEquals(getListOfCheckoutDto().toString(), checkoutProductDtoList.toString());

    }

    @Test
    @DisplayName("Test throw error  method  listOfCheckoutProductDto() ")
    void testThrowListOfCheckoutProductDto() {

        when(checkoutProductRepository.findAll()).thenReturn(Collections.emptyList());
        Exception exception = assertThrows(DataNotFoundException.class, () -> checkoutProductService.listOfCheckoutProductDto());
        String expected = "Checkout Product list it's empty";
        String actual = exception.getMessage();
        assertEquals(expected, actual);


    }

    @Test()
    @DisplayName("Test method listOfCheckoutProductDtoByIdUser")
    void testListOfCheckoutProductDtoByIdUser() {
        when(checkoutProductRepository.getCheckoutProductByIdUser(1L)).thenReturn(getListOfCheckout());
        List<CheckoutProductDto> checkoutProductDtoList = checkoutProductService.getListOfCheckoutProductByIdUser(1L);
        assertEquals(getListOfCheckoutDto().toString(), checkoutProductDtoList.toString());

    }


    @Test
    @DisplayName("Test throw error  method  listOfCheckoutProductDtoByIdUser()")
    void testThrowListOfCheckoutProductDtoByIdUser() {

        when(checkoutProductRepository.getCheckoutProductByIdUser(1L)).thenReturn(Collections.emptyList());
        Exception exception = assertThrows(DataNotFoundException.class, () -> checkoutProductService.getListOfCheckoutProductByIdUser(1L));
        String expected = "Checkout Product list it's empty";
        String actual = exception.getMessage();
        assertEquals(expected, actual);


    }

}