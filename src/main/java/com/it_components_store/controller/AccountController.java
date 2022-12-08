package com.it_components_store.controller;

import com.it_components_store.entity.User;
import com.it_components_store.security.SecurityUsers;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/home")
    public String getRamPage(Model model, Authentication authentication) {
        SecurityUsers securityUsers = (SecurityUsers) authentication.getPrincipal();
        User user = securityUsers.getUser();
        model.addAttribute("user",user);
        return "myAccount/profile";

    }
}
