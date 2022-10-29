package com.it_components_store.controller;

import com.it_components_store.dto.UserDto;
import com.it_components_store.entity.User;
import com.it_components_store.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserServiceImpl userService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }
    @PostMapping("/registerUser")
    public String userRegister(@ModelAttribute("user") UserDto user){
        userService.addUsers(user);
         return "redirect:/login";
    }
}
