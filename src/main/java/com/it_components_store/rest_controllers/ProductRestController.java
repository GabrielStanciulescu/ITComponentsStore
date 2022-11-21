package com.it_components_store.rest_controllers;

import com.it_components_store.dto.ProductDto;
import com.it_components_store.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductRestController {

    private final ProductServiceImpl productService;

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductDto product) {

        productService.addProduct(product);

    }

    @GetMapping("/{id}")
    public Optional<ProductDto> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/all")
    public List<ProductDto> getAllProduct() {
        return productService.getListOfProduct();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/allbycategory/{id}")
    public List<ProductDto> getAllProductByCategory(@PathVariable Long id) {
        return productService.getListOfProductsByCategory(id);
    }


}
