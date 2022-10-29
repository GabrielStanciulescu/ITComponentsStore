package com.it_components_store.rest_controllers;

import com.it_components_store.dto.ProductDto;
import com.it_components_store.repository.ProductRepository;
import com.it_components_store.service.impl.ProductServiceImpl;
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
@RequestMapping(value = "/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductServiceImpl productService;
    private final ProductRepository productRepository;

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
