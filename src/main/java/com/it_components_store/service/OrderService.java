package com.it_components_store.service;

import com.it_components_store.dto.OrderDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void addOrder(OrderDto orderDto);
    Optional<OrderDto> getOrderById(Long id);
    List<OrderDto> listOfOrders();
    void deleteOrderByID(Long id);
    List<OrderDto> getOrderByOrderCode(String keywords);

}
