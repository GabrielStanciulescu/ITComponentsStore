package com.it_components_store.rest_controllers;

import com.it_components_store.dto.OrderDto;
import com.it_components_store.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderRestController {
    private final OrderService orderService;

    @PostMapping("/add")
    public void addProduct( @Valid  @RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
    }

    @GetMapping("/{id}")
    public Optional<OrderDto> getOrderByID(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/ollOrder")
    public List<OrderDto> getAllOrder() {
        return orderService.listOfOrders();
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        orderService.deleteOrderByID(id);

    }
}
