package com.it_components_store.service;


import com.it_components_store.dto.CheckoutProductDto;

import java.util.List;

public interface CheckoutProductService {
    void addCheckoutProduct(CheckoutProductDto checkoutProductDto);
    List<CheckoutProductDto> listOfCheckoutProductDto();
    List<CheckoutProductDto> getListOfCheckoutProductByIdUser(Long idUSer);
}
