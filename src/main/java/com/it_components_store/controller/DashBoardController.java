package com.it_components_store.controller;


import com.it_components_store.dto.ProductDto;
import com.it_components_store.dto.UserDto;
import com.it_components_store.entity.User;
import com.it_components_store.service.ProductService;
import com.it_components_store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class DashBoardController {
    private final ProductService productService;
    private final UserService userService;

    @GetMapping()
    public String showProduct(Model model) {
        List<ProductDto> productList = productService.getListOfProduct();
        model.addAttribute("productList", productList);

        return "dashboard/dashboard";
    }

    @GetMapping("/product/new")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new ProductDto());
        return "dashboard/add";
    }

    @PostMapping("/product/save")
    public String saveNewProduct(@ModelAttribute("product") @Valid ProductDto productDto, Errors errors) {
        if (errors.hasErrors()) {
            return "dashboard/add";
        } else {
            productService.addProduct(productDto);
            return "redirect:/dashboard";
        }
    }
    @GetMapping("/product/update/{id}")
    public String viewUpdateProduct(Model model, @PathVariable Long id) {
        Optional<ProductDto> productDtoOptional = productService.getProductById(id);
        if (productDtoOptional.isPresent()) {
            ProductDto productDto = productDtoOptional.get();
            model.addAttribute("productDto", productDto);

        }
        return "dashboard/modify";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@Valid @ModelAttribute("productDto") ProductDto productDto, Errors errors, @PathVariable Long id, Model model) {
        productDto.setIdProduct(id);
        model.addAttribute("productDto", productDto);
        if (errors.hasErrors()) {
            return "dashboard/modify";
        } else {
            productService.updateProduct(productDto, id);

            return "redirect:/dashboard";
        }
    }
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {

        productService.deleteProductById(id);

        return "redirect:/dashboard";
    }

    @GetMapping("/search/dashboard")
    public String getProductByDescription(Model model, String keyword) {
        String search = keyword.trim();
        List<ProductDto> productList = productService.getProductByDescription(search);
        model.addAttribute("productList", productList);
        return "dashboard/dashboard";
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        List<UserDto> userDtoList = userService.getListOfUsers();
        model.addAttribute("userDtoList", userDtoList);
        return "dashboard/dashboardUsers";

    }
    @GetMapping("/users/add")
    public String getPageAddNewUser(Model model){
        model.addAttribute("user", new User());
        return "dashboard/addUser";
    }
    @PostMapping("/users/add/newUser")
    public String addNewUser(@Valid @ModelAttribute("user") UserDto user, Errors errors){
        if (errors.hasErrors()) {
            return "dashboard/users/add";
        } else {
            userService.addUsers(user);
            return "redirect:/dashboard/users";
        }
    }
    @GetMapping("/users/update/{id}")
    public String viewUpdateUser(Model model, @PathVariable Long id){
        Optional<UserDto> optionalUserDto = userService.getUsersById(id);
        if(optionalUserDto.isPresent()){
            UserDto userDto = optionalUserDto.get();
            model.addAttribute("user", userDto);
        }


        return "dashboard/modifyUser";
    }

    @PostMapping("/users/updateUser/{id}")
    public String updateUser(@ModelAttribute("user")UserDto userDto, @PathVariable Long id, Model model){
        userDto.setIdUser(id);
        model.addAttribute("user", userDto);

            userService.updateUser(userDto, id);
            return "redirect:/dashboard/users";

    }
    @GetMapping("/users/search")
    public String searchUser(Model model, String keyword){
        String search = keyword.trim();
        List<UserDto> userDtoList = userService.getUsersByFirstName(search);
        model.addAttribute("userDtoList", userDtoList);
        return "dashboard/dashboardUsers";
    }

    @PostMapping("/users/delete/{id}")
     public String deleteUserById(@PathVariable Long id){

        userService.deleteUserById(id);

        return "redirect:/dashboard/users";
    }






}
