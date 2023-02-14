package com.it_components_store.mocks.MocksDto;

import com.it_components_store.dto.OrderDto;

import java.util.List;

public class OrderMockDto {

    public static OrderDto getOneOrderDto(){
        return OrderDto.builder().idProduct(1L).description("Test").quantity(1000).build();
    }

    public static List<OrderDto> getListOfOrderDto(){
        return List.of(OrderDto.builder().idProduct(1L).description("Test").quantity(1000).build(),
                OrderDto.builder().idProduct(1L).description("Test").quantity(1000).build()
        );
    }
}
