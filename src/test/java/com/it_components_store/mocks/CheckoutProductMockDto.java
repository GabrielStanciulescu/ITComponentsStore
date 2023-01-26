package com.it_components_store.mocks;

import com.it_components_store.dto.CheckoutProductDto;
import com.it_components_store.entity.User;

import java.util.List;

public class CheckoutProductMockDto {

    public static CheckoutProductDto getOneCheckoutDto() {

        return CheckoutProductDto.builder().price(100).orderCode("1256klk").id(1L).idUser(1L).price(12565).build();
    }

    public static List<CheckoutProductDto> getListOfCheckoutDto() {
        return List.of(
                CheckoutProductDto.builder().price(100).orderCode("1256klk").id(1L).idUser(1L).price(12565).build(),
                CheckoutProductDto.builder().price(100).orderCode("1256klk").id(1L).idUser(1L).price(12565).build()
        );
    }
}
