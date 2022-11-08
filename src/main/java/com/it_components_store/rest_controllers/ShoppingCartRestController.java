package com.it_components_store.rest_controllers;

import com.it_components_store.dto.ProductDto;
import com.it_components_store.dto.ShoppingCartDto;
import com.it_components_store.service.impl.ProductServiceImpl;
import com.it_components_store.service.impl.ShoppingCartServiceImpl;
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
    private final ShoppingCartServiceImpl shoppingCartService;
    private final ProductServiceImpl productService;
    private final ModelMapper modelMapper;

    @PostMapping("/add/{id}")
    public void addShoppingCart(@PathVariable Long id){
        Optional<ProductDto> productDtoOptionaltest = productService.getProductById(id);
        if(productDtoOptionaltest.isPresent()){
            ProductDto productDto = productDtoOptionaltest.get();
            ShoppingCartDto shoppingCartDto = modelMapper.map(productDto, new TypeToken<ShoppingCartDto>() {}.getType());
            shoppingCartDto.setQuantity(1);
            shoppingCartService.addShoppingCart(shoppingCartDto);
        }
    }
    @GetMapping("/getShopping/{id}")
    public Optional<ShoppingCartDto> getShoppingCart(@PathVariable Long id){
        return shoppingCartService.getShoppingCartById(id);

    }

}
