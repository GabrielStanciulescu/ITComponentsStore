package com.it_components_store.mocks;

import com.it_components_store.entity.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShoppingCartMock {
    public static ShoppingCart getOneShoppingCart(){
       User user=  User.builder().idUser(1L).build();

        Product product = Product.builder().idProduct(1L).build();

        return ShoppingCart.builder().idShoppingCart(1L).user(user).product(product).description("Test").build();


    }

    public static List<ShoppingCart> getListOfShoppingCart(){
        User user=  User.builder().idUser(1L).build();

        Product product = Product.builder().idProduct(1L).build();
        ;

        return List.of(ShoppingCart.builder().idShoppingCart(1L).user(user).product(product).description("Test").build());

    }
}
