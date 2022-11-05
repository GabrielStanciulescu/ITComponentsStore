package com.it_components_store.service;

import com.it_components_store.dto.OrderDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    void addOrder(OrderDto orderDto);
    Optional<OrderDto> getOrderById(UUID id);
    List<OrderDto> listOfOrders();
    void deleteOrderByID(UUID id);

}
