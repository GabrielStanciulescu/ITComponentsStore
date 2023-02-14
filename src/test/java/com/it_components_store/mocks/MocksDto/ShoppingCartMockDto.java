package com.it_components_store.mocks.MocksDto;

import com.it_components_store.dto.ShoppingCartDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShoppingCartMockDto {

    public static ShoppingCartDto getOneShoppingCartDto(){
        return ShoppingCartDto.builder().idShoppingCart(1L).idUser(1L).idProduct(1L).description("Test").build();
    }

    public static List<ShoppingCartDto> getListOfShoppingCartDTO(){

        return List.of(ShoppingCartDto.builder().idShoppingCart(1L).idUser(1L).idProduct(1L).description("Test").build());
    }



}
