package com.it_components_store.controller;

import com.it_components_store.dto.CheckoutProductDto;
import com.it_components_store.dto.OrderDto;
import com.it_components_store.entity.User;
import com.it_components_store.security.SecurityUsers;
import com.it_components_store.service.CheckoutProductService;
import com.it_components_store.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final CheckoutProductService checkoutProductService;
    private final OrderService orderService;

    @GetMapping("/home")
    public String getAccountPage(Model model, Authentication authentication) {
        SecurityUsers securityUsers = (SecurityUsers) authentication.getPrincipal();
        User user = securityUsers.getUser();
        model.addAttribute("user",user);
        return "myAccount/profile";

    }

    @GetMapping("/order")
    public String getOrderAccount(Model  model, Authentication authentication){
        SecurityUsers securityUsers = (SecurityUsers) authentication.getPrincipal();
        List<CheckoutProductDto> checkoutProductDtoList = checkoutProductService.getListOfCheckoutProductByIdUser(securityUsers.getUser().getIdUser());
        model.addAttribute("checkoutProduct", checkoutProductDtoList);
        return "myAccount/orderAccountPage";
    }

    @GetMapping("/search/{orderCode}")
    public String getOrderByCode(Model  model, @PathVariable String orderCode){
        List<OrderDto> orderDtoList = orderService.getOrderByOrderCode(orderCode);
        model.addAttribute("orderList", orderDtoList);


        return "myAccount/orderSearch";
    }







}
