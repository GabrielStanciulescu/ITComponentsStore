package com.it_components_store.service.impl;

import com.it_components_store.dto.OrderDto;
import com.it_components_store.entity.Order;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.repository.OrderRepository;
import com.it_components_store.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addOrder(OrderDto orderDto) {
        if (orderDto == null) {
            throw new DataNotFoundException("Order not found!");
        } else {
            Order order = modelMapper.map(orderDto, new TypeToken<Order>() {
            }.getType());
            orderRepository.save(order);
        }
    }

    @Override
    public Optional<OrderDto> getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            throw new DataNotFoundException("The Order with id " + id + " does not exist!");
        } else {
            Order order = optionalOrder.get();
            OrderDto orderDto = modelMapper.map(order, OrderDto.class);
            return Optional.of(orderDto);
        }
    }

    @Override
    public List<OrderDto> listOfOrders() {
        List<Order> orderList = orderRepository.findAll();
        if (orderList.isEmpty()) {
            throw new DataNotFoundException("Order list it's empty");
        } else {
            List<OrderDto> orderDtoList;
            orderDtoList = modelMapper.map(orderList, new TypeToken<List<OrderDto>>() {
            }.getType());
            return orderDtoList;
        }

    }

    @Override
    public void deleteOrderByID(Long id) {

        Optional<Order> orderDtoOptional = orderRepository.findById(id);

        if (orderDtoOptional.isEmpty()) {
            throw new DataNotFoundException("Order with id " + id + " it's not present in database");
        }
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDto> getOrderByOrderCode(String keywords) {
        List<Order> orderList = orderRepository.findAllByOrderCodeIsContainingIgnoreCase(keywords);
        if (orderList.isEmpty()) {
            throw new DataNotFoundException("Order list it's empty");
        }
        List<OrderDto> orderDtoList;
        orderDtoList = modelMapper.map(orderList, new TypeToken<List<OrderDto>>() {
        }.getType());
        return orderDtoList;
    }

}
