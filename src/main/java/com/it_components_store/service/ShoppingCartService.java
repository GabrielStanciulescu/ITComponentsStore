package com.it_components_store.service;

import com.it_components_store.dto.ShoppingCartDto;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {
    void addShoppingCart(ShoppingCartDto shoppingCartDto);
    Optional<ShoppingCartDto> getShoppingCartById(Long id);
    List<ShoppingCartDto> getListOfShoppingCart();
    void deleteShoppingCartById(Long id);
    void deleteAll();


}
