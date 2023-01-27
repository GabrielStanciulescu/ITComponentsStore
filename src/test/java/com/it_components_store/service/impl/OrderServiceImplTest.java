package com.it_components_store.service.impl;

import com.it_components_store.dto.OrderDto;
import com.it_components_store.entity.Order;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.it_components_store.mocks.MocksDto.OrderMockDto.getListOfOrderDto;
import static com.it_components_store.mocks.MocksDto.OrderMockDto.getOneOrderDto;
import static com.it_components_store.mocks.OrderMock.getListOfOrder;
import static com.it_components_store.mocks.OrderMock.getOneOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {
    @InjectMocks
    OrderServiceImpl orderService;

    @Mock
    OrderRepository orderRepository;

    @Spy
    ModelMapper modelMapper;

    @Captor
    ArgumentCaptor<Order> orderArgumentCaptor;
    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;


    @Test
    @DisplayName("Test method addOrder()")
    void testAddOrder() {
        OrderDto orderDto = getOneOrderDto();
        orderService.addOrder(orderDto);
        verify(orderRepository).save(orderArgumentCaptor.capture());
        assertEquals(getOneOrder(),orderArgumentCaptor.getValue());
    }
    @Test
    @DisplayName("Test throw Exception method addOrder()")
    void testThrowAddOrder(){
        Exception exception = assertThrows(DataNotFoundException.class,()->orderService.addOrder(null));
        String expected = "Order not found!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Test method getOrderById()")
    void testGetOrderById(){
        when(orderRepository.findById(1L)).thenReturn(Optional.of(getOneOrder()));
        Optional<OrderDto> optionalOrderDto = orderService.getOrderById(1L);
        optionalOrderDto.ifPresent(orderDto -> assertEquals(orderDto, getOneOrderDto()));
    }
    @Test
    @DisplayName("Test throw exception method  getOrderById()")
    void testThrowGetOrderById(){
        when(orderRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(DataNotFoundException.class,()->orderService.getOrderById(1L));
        String expected = "The Order with id 1 does not exist!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Test method listOfOrders() ")
    void testListOfOrders(){
        when(orderRepository.findAll()).thenReturn(getListOfOrder());
        List<OrderDto> orderDtoList = orderService.listOfOrders();
        assertEquals(getListOfOrderDto(), orderDtoList);
    }

    @Test
    @DisplayName("Test throw exception method listOfOrders()")
    void testThrowListOfOrders(){
        when(orderRepository.findAll()).thenReturn(Collections.emptyList());
        Exception exception = assertThrows(DataNotFoundException.class,()->orderService.listOfOrders());
        String expected = "Order list it's empty";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Test method deleteOrderByID()")
    void testDeleteOrderByID(){
        when(orderRepository.findById(1L)).thenReturn(Optional.of(getOneOrder()));
        orderService.deleteOrderByID(1L);
        verify(orderRepository, times(1)).deleteById(longArgumentCaptor.capture());
        assertEquals(1, longArgumentCaptor.getValue());

    }

    @Test
    @DisplayName("Test throw error method deleteOrderByID()")
    void testThrowDeleteOrderByID(){
        when(orderRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(DataNotFoundException.class,()->orderService.deleteOrderByID(1L));
        String expected = "Order with id 1 it's not present in database";
        String actual = exception.getMessage();
        assertEquals(expected,actual);

    }
    @Test
    @DisplayName("Test method getOrderByOrderCode()")
    void testGetOrderByOrderCode(){
        when(orderRepository.findAllByOrderCodeIsContainingIgnoreCase("test")).thenReturn(getListOfOrder());
       List<OrderDto> orderDtoList = orderService.getOrderByOrderCode("test");
       assertEquals(getListOfOrderDto(), orderDtoList);

    }
    @Test
    @DisplayName("Test throw exception for getOrderByOrderCode() ")
    void testThrowGetOrderByOrderCode(){
        Exception exception = assertThrows(DataNotFoundException.class,()->orderService.getOrderByOrderCode("Test"));
        String expected = "Order list it's empty";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

}




