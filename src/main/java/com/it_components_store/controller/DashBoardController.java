package com.it_components_store.controller;

//import com.it_components_store.entity.ProductDto;
import com.it_components_store.dto.ProductDto;
import com.it_components_store.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/dashboard/product/update/{id}")
    public String viewUpdateProduct( Model model, @PathVariable Long id){
        Optional<ProductDto> productDtoOptional = productService.getProductById(id);
        ProductDto productDto = productDtoOptional.get();
        model.addAttribute("productDto",productDto );

        return "modify";
    }

    @PostMapping("/dashboard/update/{id}")
    public String updateProduct(@ModelAttribute("productDto") ProductDto productDto, @PathVariable Long id){
        System.out.println("Este apelata");
        productService.updateProduct(productDto, id);

        return "redirect:/dashboard";
    }

    @DeleteMapping("/dashboard/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        System.out.println("Este apelata");
        productService.deleteProductById(id);

        return "redirect:/dashboard";
    }








}
