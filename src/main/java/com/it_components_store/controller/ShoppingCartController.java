package com.it_components_store.controller;

import com.it_components_store.dto.ProductDto;
import com.it_components_store.dto.ShoppingCartDto;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.security.SecurityUsers;
import com.it_components_store.service.ProductService;
import com.it_components_store.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Transactional
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;
    private final ModelMapper modelMapper;



    @GetMapping("/shoppingcart")
    public String getShoppingCart(Model model, Authentication authentication) {
        SecurityUsers securityUsers = (SecurityUsers) authentication.getPrincipal();
        List<ShoppingCartDto> shoppingCart = shoppingCartService.getListOfShoppingCartByUserId(securityUsers.getUser().getIdUser());
        int price = 0;
        for (ShoppingCartDto shoppingCartDto : shoppingCart) {
            int quantity = shoppingCartDto.getQuantity();

            price += shoppingCartDto.getPrice() * quantity;

        }
        model.addAttribute("shoppingCart", shoppingCart);
        model.addAttribute("price", price);
        return "principalPage/shoppingCart";
    }

    @PostMapping("/add/cart/{id}/{idCategory}")
    public String addShoppingCart(@PathVariable Long id, @PathVariable Long idCategory, Integer quantity, Authentication authentication) {
        SecurityUsers securityUsers = (SecurityUsers) authentication.getPrincipal();
        Optional<ProductDto> productDtoOptional = productService.getProductById(id);
        if (productDtoOptional.isEmpty()) {
            throw new DataNotFoundException("Product not found");
        }

        ProductDto productDto = productDtoOptional.get();
        ShoppingCartDto shoppingCartDto = modelMapper.map(productDto, new TypeToken<ShoppingCartDto>() {
        }.getType());
        shoppingCartDto.setQuantity(Objects.requireNonNullElse(quantity, 1));
        shoppingCartDto.setIdUser(securityUsers.getUser().getIdUser());

        shoppingCartService.addShoppingCart(shoppingCartDto);
        return "redirect:/category/" + idCategory;
    }

    @PostMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        shoppingCartService.deleteShoppingCartById(id);

        return "redirect:/shoppingcart";
    }
}

