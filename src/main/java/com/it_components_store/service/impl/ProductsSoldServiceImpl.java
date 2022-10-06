package com.it_components_store.service.impl;

import com.it_components_store.entity.SoldProducts;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.exception.InvalidDataException;
import com.it_components_store.repository.ProductsSoldRepository;
import com.it_components_store.service.ProductsSoldService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductsSoldServiceImpl implements ProductsSoldService {

    private final ProductsSoldRepository productsSoldRepository;

    @Override
    public void addProductsSold(SoldProducts productsSold) {
        if (productsSold == null) {
            throw new DataNotFoundException("Error! SoldProducts not found!");
        } else {
            productsSoldRepository.save(productsSold);
        }
    }

    @Override
    public Optional<SoldProducts> getProductsSoldById(Long id) {
        if (id < 0) {
            throw new InvalidDataException("Error! Your id " + id + " it's not valid");
        }
        Optional<SoldProducts> optionalProductsSold = productsSoldRepository.findById(id);
        if (optionalProductsSold.isEmpty()) {
            throw new DataNotFoundException("Error! The products sold with  id " + id + " does not exist!");
        } else {
            return optionalProductsSold;
        }
    }

    @Override
    public List<SoldProducts> listOfProductsSold() {
        List<SoldProducts> productsSoldList = productsSoldRepository.findAll();
        if (productsSoldList.isEmpty()) {
            throw new DataNotFoundException("Error! productsSold list it's empty");
        } else {
            return productsSoldList;
        }
    }

    @Override
    public void deleteProductsSoldById(Long id) {
        Optional<SoldProducts> categoryOptional = productsSoldRepository.findById(id);
        if (id < 0) {
            throw new InvalidDataException("Error! Your id " + id + " it's not valid, pleas try again with id >=0");
        }
        if (categoryOptional.isEmpty()) {
            throw new DataNotFoundException("Error  Product with id " + id + " it's not present in database");
        }
        productsSoldRepository.deleteById(id);
    }
}
