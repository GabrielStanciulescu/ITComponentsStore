package com.it_components_store.rest_controllers;

import com.it_components_store.entity.Category;
import com.it_components_store.entity.Product;
import com.it_components_store.service.impl.CategoryServiceImpl;
import com.it_components_store.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    private final ProductServiceImpl productService;
    private final CategoryServiceImpl categoryService;

    @PostMapping("/{category}")
    public void addProduct(@RequestBody Product product, @PathVariable Long category){
        Optional<Category> optionalCategory = categoryService.getCategoryById(category);
        if(optionalCategory.isPresent()){
            product.setCategory(optionalCategory.get());
            productService.adProduct(product);
        }

    }
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }


    @GetMapping("/all")
    public List<Product> getAllProduct(){
        return productService.getListOfProduct();
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable  Long id){
        productService.deleteProductById(id);

    }


}
