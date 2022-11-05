package com.it_components_store.service.impl;

import com.it_components_store.dto.ProductDto;
import com.it_components_store.entity.Category;
import com.it_components_store.entity.Product;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.exception.InvalidDataException;
import com.it_components_store.repository.CategoryRepository;
import com.it_components_store.repository.ProductRepository;
import com.it_components_store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private  final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    @Override
    public void addProduct(ProductDto productDto) {
        if (productDto == null) {
            throw new DataNotFoundException("Product not found!");
        } else {
             Product product = modelMapper.map(productDto, new TypeToken<Product>() {}.getType());
             productRepository.save(product);
        }
    }
    @Override
    public Optional<ProductDto> getProductById(Long id) {
        if (id < 0) {
            throw new InvalidDataException("Your id " + id + " it's not valid");
        }
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new DataNotFoundException("Error! The product with id " + id + " does not exist!");
        } else {
            Product product = optionalProduct.get();
            ProductDto productDto = modelMapper.map(product,ProductDto.class);
            return Optional.of(productDto);
        }

    }
    @Override
    public List<ProductDto> getListOfProduct() {
        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty()) {
            throw new DataNotFoundException("Product list it's empty");
        } else {
            List<ProductDto> productDtoList;
            productDtoList = modelMapper.map(productList, new TypeToken<List<ProductDto>>() {}.getType());
            return  productDtoList;
        }

    }
    @Override
    public void deleteProductById(Long id) {

        Optional<Product> categoryOptional = productRepository.findById(id);
        if (id < 0) {
            throw new InvalidDataException("Your id " + id + " it's not valid, please try again with id >=0");
        }
        if (categoryOptional.isEmpty()) {
            throw new DataNotFoundException("Category with id " + id + " it's not present in database");
        }
        productRepository.deleteById(id);
    }
    @Override
    public void updateProduct(ProductDto productDto, Long id) {
        Product product = productRepository.findById(id).orElseThrow(()->new DataNotFoundException("Category with id " + id + " it's not present in database"));
        Long idCategory = productDto.getCategoryId();
        Category categoryFromDto = categoryRepository.findById(idCategory).orElseThrow(()->new DataNotFoundException("Category with id " + idCategory + " it's not present in database"));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setDescription(productDto.getDescription());
        product.setCode(productDto.getCode());
        product.setQuantity(productDto.getQuantity());
        product.setCategory(categoryFromDto);
        product.setImageUrl(productDto.getImageUrl());
        productRepository.save(product);
    }

    @Override
    public List<ProductDto> getListOfProductsByCategory(Long id) {
        List<Product> productList = productRepository.getAllByCategory_IdCategory(id);
        if (productList.isEmpty()) {
            throw new DataNotFoundException("Product list it's empty");
        } else {
            List<ProductDto> productDtoList;
            productDtoList = modelMapper.map(productList, new TypeToken<List<ProductDto>>() {}.getType());
            return  productDtoList;
        }
    }
    @Override
    public List<ProductDto> getProductByDescription(String description) {
        List<Product> productList = productRepository.findAllByDescriptionIsContainingIgnoreCase(description);
        if (productList.isEmpty()) {
            throw new DataNotFoundException("Product list it's empty");
        } else {
            List<ProductDto> productDtoList;
            productDtoList = modelMapper.map(productList, new TypeToken<List<ProductDto>>() {}.getType());
            return  productDtoList;
        }
    }
    @Override
    public List<ProductDto> getByCustomSearch(String custom) {
        List<Product> productList = productRepository.findByCustomSearch(custom);
        if (productList.isEmpty()) {
            throw new DataNotFoundException("Product list it's empty");
        } else {
            List<ProductDto> productDtoList;
            productDtoList = modelMapper.map(productList, new TypeToken<List<ProductDto>>() {}.getType());
            return  productDtoList;
        }
    }
}