package com.it_components_store.controller;

import com.it_components_store.dto.ProductDto;
import com.it_components_store.dto.product_details_Dto.*;
import com.it_components_store.entity.product_details.Motherboard;
import com.it_components_store.service.ProductDetailsService;
import com.it_components_store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/details")
public class ProductDetailsController {
    private final ProductDetailsService productDetailsService;
    private final ProductService productService;


    @GetMapping("/{idCategory}/products/{idProduct}")
    private String getDetails(@PathVariable int idCategory, @PathVariable Long idProduct, Model model) {
        Optional<ProductDto> productDto;
        switch (idCategory) {

            case 1:
                Optional<MouseDto> mouseDto = productDetailsService.getMouseDetailsByIdCategory(idProduct);
                productDto = productService.getProductById(idProduct);
                model.addAttribute("mouse",mouseDto.get());
                model.addAttribute("link", productDto.get().getImageUrl());

                return "productDetails/MouseDetails";
            case 2:

                Optional<RamDto> ramDto = productDetailsService.getRamDetailsByIdCategory(idProduct);
                productDto = productService.getProductById(idProduct);
                model.addAttribute("ram",ramDto.get());
                model.addAttribute("link", productDto.get().getImageUrl());
                return "productDetails/RamDetails";

            case 3:
                Optional<HddDto> hddDto = productDetailsService.getHddDetailsByIdCategory(idProduct);
                productDto = productService.getProductById(idProduct);
                model.addAttribute("hdd", hddDto.get());
                model.addAttribute("link", productDto.get().getImageUrl());
                return "productDetails/HddDetails";


            case 4:
                Optional<SsdDto>ssdDto = productDetailsService.getSsdDetailsByIdCategory(idProduct);
                productDto = productService.getProductById(idProduct);
                model.addAttribute("ssd", ssdDto.get());
                model.addAttribute("link", productDto.get().getImageUrl());
                return "productDetails/SsdDetails";


            case 5:
               Optional<CpuDto> cpuDto = productDetailsService.getCpuDetailsByIdCategory(idProduct);
               productDto = productService.getProductById(idProduct);
               model.addAttribute("cpu", cpuDto.get());
               model.addAttribute("link", productDto.get().getImageUrl());
                return "productDetails/CpuDetails";

            case 6:
                Optional<GpuDto> gpuDto = productDetailsService.getGpuDetailsByIdCategory(idProduct);
                productDto = productService.getProductById(idProduct);
                model.addAttribute("gpu", gpuDto.get());
                model.addAttribute("link", productDto.get().getImageUrl());
                return "productDetails/GpuDetails";

            case 7:
                Optional<MotherboardDto> motherboardDto = productDetailsService.getMotherboardDetailsByIdCategory(idProduct);
                productDto = productService.getProductById(idProduct);
                model.addAttribute("motherboard", motherboardDto.get());
                model.addAttribute("link", productDto.get().getImageUrl());
                return "productDetails/MotherboardDetails";


            default:
                return "login/login";
        }



    }

}
