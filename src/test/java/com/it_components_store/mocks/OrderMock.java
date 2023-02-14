package com.it_components_store.mocks;

import com.it_components_store.entity.Order;

import java.util.List;

public class OrderMock {


    public static Order getOneOrder(){
        return Order.builder().idProduct(1L).description("Test").quantity(1000).build();
    }

    public static List<Order> getListOfOrder(){
        return List.of(Order.builder().idProduct(1L).description("Test").quantity(1000).build(),
                Order.builder().idProduct(1L).description("Test").quantity(1000).build()
        );
    }
}
