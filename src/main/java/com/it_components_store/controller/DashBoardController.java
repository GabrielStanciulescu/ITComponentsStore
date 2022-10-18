package com.it_components_store.controller;

//import com.it_components_store.entity.ProductDto;
import com.it_components_store.dto.ProductDto;
import com.it_components_store.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DashBoardController {
    private final ProductServiceImpl productService;

    @GetMapping("/dashboard")
    public String showProduct(Model model){
        List<ProductDto> productList = productService.getListOfProduct();
        model.addAttribute("productList", productList);
        return "dashboard";
    }

    @GetMapping("/dashboard/product/new")
    public String addNewProduct(Model model){
        model.addAttribute("product", new ProductDto());
        return "add";
    }
    @PostMapping("/dashboard/product/save")
    public String saveNewProduct( @ModelAttribute("product") ProductDto productDto){
        productService.adProduct(productDto);
        return "redirect:/dashboard";


    }





}
