package com.ITComponentsStore.RestControllers;

import com.ITComponentsStore.Entity.Product;
import com.ITComponentsStore.Entity.ProductsSold;
import com.ITComponentsStore.Service.impl.ProductServiceImpl;
import com.ITComponentsStore.Service.impl.ProductsSoldServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/productsSold", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductsSoldController {
    private final ProductsSoldServiceImpl productsSoldService;
    private final ProductServiceImpl productService;

    @PostMapping("/{products}")
    public void addProductsSold(@RequestBody ProductsSold productsSold,  @PathVariable  Long products){
        Optional<Product> productOptional = productService.getProductById(products);
      if (productOptional.isPresent()){
          productsSold.setProduct(productOptional.get());
          productsSoldService.addProductsSold(productsSold);
      }

    }
    @GetMapping("/{id}")
    Optional<ProductsSold> getProductsSoldById(@PathVariable Long id){
        return productsSoldService.getProductsSoldById(id);
    }

    @GetMapping("/all")
    List<ProductsSold> getAllProductsSold(){
        return productsSoldService.listOfProductsSold();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        productsSoldService.deleteProductsSoldById(id);
    }

}
