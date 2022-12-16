package com.it_components_store.rest_controllers;

import com.it_components_store.dto.ProductDto;
import com.it_components_store.dto.ShoppingCartDto;
import com.it_components_store.service.ProductService;
import com.it_components_store.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/shopping", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingCartRestController {
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @PostMapping("/add/{id}")
    public void addShoppingCart(@PathVariable Long id) {
        Optional<ProductDto> productDtoOptionaltest = productService.getProductById(id);
        if (productDtoOptionaltest.isPresent()) {
            ProductDto productDto = productDtoOptionaltest.get();
            ShoppingCartDto shoppingCartDto = modelMapper.map(productDto, new TypeToken<ShoppingCartDto>() {
            }.getType());
            shoppingCartDto.setQuantity(1);
            shoppingCartService.addShoppingCart(shoppingCartDto);
        }
    }

    @GetMapping("/getShopping/{id}")
    public Optional<ShoppingCartDto> getShoppingCart(@PathVariable Long id) {
        return shoppingCartService.getShoppingCartById(id);

    }

    @DeleteMapping("/delete/{id}")
    void deleteByid(@PathVariable Long id){
        shoppingCartService.deleteByIdUser(id);
    }

}
