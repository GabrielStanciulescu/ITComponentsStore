package com.it_components_store.service.impl;

import com.it_components_store.dto.CheckoutProductDto;
import com.it_components_store.entity.CheckoutProduct;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.repository.CheckoutProductRepository;
import com.it_components_store.service.CheckoutProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckoutProductServiceImpl implements CheckoutProductService {
    private final CheckoutProductRepository checkoutProductRepository;
    private final ModelMapper modelMapper;
    @Override
    public void addCheckoutProduct(CheckoutProductDto checkoutProductDto) {
        if(checkoutProductDto==null){
            throw new DataNotFoundException("Order not found!");
        }
        else{
            CheckoutProduct checkoutProduct = modelMapper.map(checkoutProductDto, new TypeToken<CheckoutProduct>() {}.getType());
            checkoutProductRepository.save(checkoutProduct);
        }
    }
}
