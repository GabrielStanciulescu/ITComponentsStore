package com.ITComponentsStore.Service.impl;

import com.ITComponentsStore.Entity.Product;
import com.ITComponentsStore.Entity.ProductsSold;
import com.ITComponentsStore.Exception.DataNotFoundException;
import com.ITComponentsStore.Exception.InvalidDataException;
import com.ITComponentsStore.Repository.ProductsSoldRepository;
import com.ITComponentsStore.Service.ProductsSoldService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductsSoldServiceImpl implements ProductsSoldService{
    private final ProductsSoldRepository productsSoldRepository;
    @Override
    public void addProductsSold(ProductsSold productsSold) {
        if(productsSold==null){
            throw new DataNotFoundException("Error! ProductsSold not found!");
        }
        else {
            productsSoldRepository.save(productsSold);
        }

    }

    @Override
    public Optional<ProductsSold> getProductsSoldById(Long id) {
        if(id<0){
            throw new InvalidDataException("Error! Your id" + id+ "it's not valid");
        }
        Optional<ProductsSold> optionalProductsSold = productsSoldRepository.findById(id);
        if(optionalProductsSold.isEmpty()){
            throw new DataNotFoundException("Error! The products sold with  id "+ id + " does not exist! ");
        }
        else {
            return optionalProductsSold;
        }
    }

    @Override
    public List<ProductsSold> listOfProductsSold() {
        List<ProductsSold> productsSoldList = productsSoldRepository.findAll();
        if(productsSoldList.isEmpty()){
            throw new DataNotFoundException("Error! productsSold list it's empty");
        }
        else{
            return productsSoldList;
        }
    }

    @Override
    public void deleteProductsSoldById(Long id) {
        Optional<ProductsSold> categoryOptional = productsSoldRepository.findById(id);
        if(id<0){
            throw new InvalidDataException("Error! Your id" + id+ " it's not valid, pleas try again with id >=0");
        }
        if(categoryOptional.isEmpty()){
            throw new DataNotFoundException("Error  Product with id " + id + " it's not present in database");
        }

        productsSoldRepository.deleteById(id);


    }
}
