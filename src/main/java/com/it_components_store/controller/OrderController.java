package com.it_components_store.controller;

import com.it_components_store.dto.CheckoutProductDto;
import com.it_components_store.dto.OrderDto;
import com.it_components_store.dto.ProductDto;
import com.it_components_store.dto.ShoppingCartDto;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.service.CheckoutProductService;
import com.it_components_store.service.OrderService;
import com.it_components_store.service.ProductService;
import com.it_components_store.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;
    private final CheckoutProductService checkoutProductService;
    private final ModelMapper modelMapper;
    private final ProductService productService;

    @GetMapping("/orderpage")
    public String getOrderPage(Model model) {
        model.addAttribute("order", new OrderDto());
        return "principalPage/order";
    }

    @PostMapping("/orderpage/orderproducts")
    public String order(@ModelAttribute("order") @Valid OrderDto orderDto, Errors errors) {
       if(errors.hasErrors()){
           return "principalPage/order";
       }
       else {
           List<ShoppingCartDto> shoppingCartDtoList = shoppingCartService.getListOfShoppingCart();
           if (shoppingCartDtoList.isEmpty()) {
               throw new DataNotFoundException("Exception!");
           } else {
               int leftLimit = 97;
               int rightLimit = 122;
               int targetStringLength = 10;
               Random random = new Random();
               int totalPrice = 0;
               String generatedString = random.ints(leftLimit, rightLimit + 1)
                       .limit(targetStringLength)
                       .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                       .toString();
               for (ShoppingCartDto shoppingCartDto : shoppingCartDtoList) {
                   orderDto.setDescription(shoppingCartDto.getDescription());
                   orderDto.setQuantity(shoppingCartDto.getQuantity());
                   orderDto.setOrderCode(generatedString);
                   orderDto.setIdProduct(shoppingCartDto.getIdProduct());
                   orderDto.setPrice(shoppingCartDto.getPrice());
                   totalPrice += shoppingCartDto.getPrice() * shoppingCartDto.getQuantity();
                   orderService.addOrder(orderDto);

                   Optional<ProductDto> optionalProductDto = productService.getProductById(shoppingCartDto.getIdProduct());
                   if (optionalProductDto.isEmpty()) {
                       throw new DataNotFoundException("Product not found");

                   } else {
                       ProductDto productDto = optionalProductDto.get();
                       Integer numberOfProducts = productDto.getQuantity();
                       productDto.setQuantity(numberOfProducts - shoppingCartDto.getQuantity());
                       productService.updateProduct(productDto, productDto.getIdProduct());
                   }

               }
               CheckoutProductDto checkoutProductDto = modelMapper.map(orderDto, new TypeToken<CheckoutProductDto>() {
               }.getType());
               checkoutProductDto.setPrice(totalPrice);
               checkoutProductDto.setLocalDate(LocalDate.now());
               checkoutProductService.addCheckoutProduct(checkoutProductDto);
               shoppingCartService.deleteAll();
           }
           return "redirect:/category/1";

       }
    }

    @GetMapping("/orderpage/dashboard")
    public String getPageOfOrder(Model model) {
        List<CheckoutProductDto> checkoutProductDtoList = checkoutProductService.listOfCheckoutProductDto();
        model.addAttribute("checkoutProduct", checkoutProductDtoList);


        return "dashboard/orderPageDashboard";
    }

    @GetMapping("/search/orderpage")
    public String getProductByDescription(Model model, String keyword) {
        String search = keyword.trim();
        List<OrderDto> orderDtoList = orderService.getOrderByOrderCode(search);
        model.addAttribute("orderList", orderDtoList);
        return "dashboard/orderPageSearch";
    }
}
