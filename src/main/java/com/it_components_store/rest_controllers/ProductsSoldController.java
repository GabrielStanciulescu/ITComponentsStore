package com.it_components_store.rest_controllers;

import com.it_components_store.entity.Product;
import com.it_components_store.entity.SoldProducts;
import com.it_components_store.service.ProductService;
import com.it_components_store.service.ProductsSoldService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/productsSold", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductsSoldController {

    private final ProductsSoldService productsSoldService;
    private final ProductService productService;

    @PostMapping("/{products}")
    public void addProductsSold(@RequestBody SoldProducts productsSold, @PathVariable Long products) {
        Optional<Product> productOptional = productService.getProductById(products);
        if (productOptional.isPresent()) {
            productsSold.setProducts(List.of(productOptional.get()));
            productsSoldService.addProductsSold(productsSold);
        }
    }

    @GetMapping("/{id}")
    Optional<SoldProducts> getProductsSoldById(@PathVariable Long id) {
        return productsSoldService.getProductsSoldById(id);
    }

    @GetMapping("/all")
    List<SoldProducts> getAllProductsSold() {
        return productsSoldService.listOfProductsSold();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productsSoldService.deleteProductsSoldById(id);
    }
}
