package com.it_components_store.controller;

//import com.it_components_store.entity.ProductDto;

import com.it_components_store.dto.ProductDto;
import com.it_components_store.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class DashBoardController {
    private final ProductServiceImpl productService;

    @GetMapping()
    public String showProduct(Model model){
        List<ProductDto> productList = productService.getListOfProduct();
        model.addAttribute("productList", productList);
        return "dashboard/dashboard";
    }

    @GetMapping("/product/new")
    public String addNewProduct(Model model){
        model.addAttribute("product", new ProductDto());
        return "dashboard/add";
    }
    @PostMapping("/product/save")
    public String saveNewProduct( @ModelAttribute("product") ProductDto productDto){
        productService.addProduct(productDto);
        return "redirect:/dashboard";

    }
    @GetMapping("/product/update/{id}")
    public String viewUpdateProduct( Model model, @PathVariable Long id){
        Optional<ProductDto> productDtoOptional = productService.getProductById(id);
        if(productDtoOptional.isPresent()){
            ProductDto productDto = productDtoOptional.get();
            model.addAttribute("productDto",productDto );

        }
        return "dashboard/modify";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@ModelAttribute("productDto") ProductDto productDto, @PathVariable Long id){

        productService.updateProduct(productDto, id);

        return "redirect:/dashboard";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){

        productService.deleteProductById(id);

        return "redirect:/dashboard";
    }

    @GetMapping("/search/dashboard")
    public String getProductByDescription(Model model, String keyword){
        List<ProductDto> productList = productService.getProductByDescription(keyword);
        model.addAttribute("productList", productList);
        return "dashboard/dashboard";
    }


}
