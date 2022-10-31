package com.it_components_store.service.impl;

import com.it_components_store.dto.ShoppingCartDto;
import com.it_components_store.entity.ShoppingCart;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.exception.InvalidDataException;
import com.it_components_store.repository.ShoppingCartRepository;
import com.it_components_store.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addShoppingCart(ShoppingCartDto shoppingCartDto) {
        if(shoppingCartDto==null){
            throw new DataNotFoundException("Product not found!");
        }
        else{
            ShoppingCart shoppingCart = modelMapper.map(shoppingCartDto, new TypeToken<ShoppingCart>() {}.getType());
            shoppingCartRepository.save(shoppingCart);
        }

    }

    @Override
    public Optional<ShoppingCartDto> getShoppingCartById(Long id) {
        if (id < 0) {
            throw new InvalidDataException("Tour id " + id + " it's not valid");
        }
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(id);
        if (shoppingCartOptional.isEmpty()) {
            throw new DataNotFoundException("Error! The product with id " + id + " does not exist!");
        } else {
            ShoppingCart shoppingCart = shoppingCartOptional.get();
            ShoppingCartDto shoppingCartDto = modelMapper.map(shoppingCart,ShoppingCartDto.class);
            return Optional.of(shoppingCartDto);
        }
    }

    @Override
    public List<ShoppingCartDto> getListOfShoppingCart() {
        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAll();
        if (shoppingCartList.isEmpty()) {
            throw new DataNotFoundException("Product list it's empty");
        } else {
            List<ShoppingCartDto> shoppingCartDtoList;
            shoppingCartDtoList = modelMapper.map(shoppingCartList, new TypeToken<List<ShoppingCartDto>>() {}.getType());
            return  shoppingCartDtoList;
        }
    }

    @Override
    public void deleteShoppingCartById(Long id) {
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(id);
        if (id < 0) {
            throw new InvalidDataException("Your id " + id + " it's not valid, please try again with id >=0");
        }
        if (shoppingCart.isEmpty()) {
            throw new DataNotFoundException("Category with id " + id + " it's not present in database");
        }
        shoppingCartRepository.deleteById(id);

    }
}
