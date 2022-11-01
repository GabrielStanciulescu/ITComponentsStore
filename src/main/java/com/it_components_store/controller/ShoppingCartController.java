package com.it_components_store.controller;

import com.it_components_store.dto.ProductDto;
import com.it_components_store.dto.ShoppingCartDto;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.service.impl.ProductServiceImpl;
import com.it_components_store.service.impl.ShoppingCartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartServiceImpl shoppingCartService;
    private final ProductServiceImpl productService;
    private final ModelMapper modelMapper;


    @GetMapping("/shoppingcart")
    public String getShoppingCart(Model model) {
        List<ShoppingCartDto> shoppingCart = shoppingCartService.getListOfShoppingCart();
        Integer price=0;
        for (ShoppingCartDto shoppingCartDto : shoppingCart) {
            price += shoppingCartDto.getPrice();
        }
        model.addAttribute("shoppingCart", shoppingCart );
        model.addAttribute("price", price);
        return "shoppingCart";
    }

    @PostMapping("/add/cart/{id}/{idProduct}")
    public String addShoppingCart(@PathVariable Long id , @PathVariable Long idProduct) {
        Optional<ProductDto> productDtoOptional = productService.getProductById(id);
        if (productDtoOptional.isEmpty()) {
           throw new DataNotFoundException("Product not found");
        }
        ProductDto productDto = productDtoOptional.get();
        ShoppingCartDto shoppingCartDto = modelMapper.map(productDto, new TypeToken<ShoppingCartDto>() {}.getType());
        shoppingCartDto.setQuantity(1);
        shoppingCartService.addShoppingCart(shoppingCartDto);
        System.out.println("arata mi id ul" + idProduct);
            return "redirect:/category/" + idProduct;
        }

        @PostMapping("/deleteproduct/{id}")
    public  String deleteProduct(@PathVariable Long id){
        shoppingCartService.deleteShoppingCartById(id);

        return "redirect:/shoppingcart";
        }
    }
