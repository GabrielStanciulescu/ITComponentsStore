package com.it_components_store.controller;

import com.it_components_store.dto.UserDto;
import com.it_components_store.entity.User;
import com.it_components_store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;
    @GetMapping()
    public String login(){
        return "login/login";
    }

    @GetMapping("/logout")
    public String logOut(){
        return "login";
    }

    @GetMapping("/error")
    public String loginError(){
        return "login/LoginError";
    }

    @GetMapping("/register")
    public String register(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "login/register";
    }
    @PostMapping("/registerUser")
    public String userRegister(@ModelAttribute("user") UserDto user){
        userService.addUsers(user);
         return "redirect:/login";
    }
}
