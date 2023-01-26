package com.it_components_store.mocks;

import com.it_components_store.entity.CheckoutProduct;
import com.it_components_store.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CheckoutProductMock {

    public static CheckoutProduct getOneCheckout(){
        User user = User.builder().idUser(1L).build();
        return CheckoutProduct.builder().price(100).orderCode("1256klk").id(1L).user(user).price(12565).build();
    }

    public static List<CheckoutProduct> getListOfCheckout(){
        User user = User.builder().idUser(1L).build();
        return List.of(
                CheckoutProduct.builder().price(100).orderCode("1256klk").id(1L).user(user).price(12565).build(),
                CheckoutProduct.builder().price(100).orderCode("1256klk").id(1L).user(user).price(12565).build()
        );
    }
}
