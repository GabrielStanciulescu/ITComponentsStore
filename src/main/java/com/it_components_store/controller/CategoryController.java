package com.it_components_store.controller;

import com.it_components_store.dto.ProductDto;
import com.it_components_store.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final ProductServiceImpl productService;
    @GetMapping("/category/{id}")
    public String getRamPage(Model model, @PathVariable Long id){
        List<ProductDto> productList = productService.getListOfProductsByCategory(id);
        model.addAttribute("productList", productList);
        return "ITpage";

    }
    @GetMapping("/search")
    public String getProductByDescription(Model model, String keyword){
        List<ProductDto> productList = productService.getProductByDescription(keyword);
        model.addAttribute("productList", productList);
        return "ITpage";
    }
}