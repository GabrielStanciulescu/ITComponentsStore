package com.ITComponentsStore.Service.impl;

import com.ITComponentsStore.Entity.Category;
import com.ITComponentsStore.Entity.Product;
import com.ITComponentsStore.Exception.DataNotFoundException;
import com.ITComponentsStore.Exception.InvalidDataException;
import com.ITComponentsStore.Repository.ProductRepository;
import com.ITComponentsStore.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public void adProduct(Product product) {
        if(product==null){
            throw new DataNotFoundException("Error! Product not found!");
        }
        else {
            productRepository.save(product);
        }

    }


    @Override
    public Optional<Product> getProductById(Long id) {
        if(id<0){
            throw new InvalidDataException("Error! Tour id" + id+ "it's not valid");
        }
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new DataNotFoundException("Error! The product with id " + id+" does not exist! ");
        }
        else {
            return optionalProduct;
        }
    }

    @Override
    public List<Product> getListOfProduct() {

        List<Product> productList = productRepository.findAll();
        if(productList.isEmpty()){
            throw new DataNotFoundException("Error! Product list it's empty");
        }
        else{
            return productList;
        }
    }

    @Override
    public void deleteProductById(Long id) {
        Optional<Product> categoryOptional = productRepository.findById(id);
        if(id<0){
            throw new InvalidDataException("Error! Your id" + id+ " it's not valid, pleas try again with id >=0");
        }
        if(categoryOptional.isEmpty()){
            throw new DataNotFoundException("Error Category with id " + id + " it's not present in database");
        }

        productRepository.deleteById(id);

    }
}
