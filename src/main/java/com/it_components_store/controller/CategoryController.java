package com.it_components_store.controller;

import com.it_components_store.dto.ProductDto;
import com.it_components_store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public String getPrincipalPage(Model model, @PathVariable Long id) {
        List<ProductDto> productList = productService.getListOfProductsByCategory(id);
        model.addAttribute("productList", productList);
        return "principalPage/ITpage";

    }

    @GetMapping("/{id}/page/{page}")
    public String getPrincipalPageTest(Model model, @PathVariable Long id, @PathVariable int page) {
        Page<ProductDto> productList = productService.getAllProductByCategory(id, page,6);
        List<ProductDto> productDtoList =  productList.getContent();
        model.addAttribute("categoryId", id);
        model.addAttribute("productList", productDtoList);
        model.addAttribute("currentPage",  page);
        model.addAttribute("totalPages", productService.getTotalNumberOfPageByCategory(id, page, 6));
        model.addAttribute("totalItem", productService.getTotalNumberOfElementsByCategory(id, page, 6));
        return "principalPage/ITpage";

    }
    @GetMapping("/search/category")
    public String getProductByDescription(Model model, String keyword) {
       String search = keyword.trim();
        List<ProductDto> productList = productService.getProductByDescription(search);
        model.addAttribute("productList", productList);
        return "principalPage/ITpageSearch";
    }

}