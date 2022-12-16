package com.it_components_store.controller;

import com.it_components_store.entity.User;
import com.it_components_store.mail.SendMail;
import com.it_components_store.mail.Utility;
import com.it_components_store.service.UserService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ForgotPasswordController {
    private final UserService userService;
    private final SendMail sendMail;

    @GetMapping("/forgot_password")
    public String showForgotPasswordForm() {
        return "login/forgot_password_form";
    }
    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, Model model ) {
        String email = request.getParameter("email");
        String token = RandomString.make(30);
        try{
            userService.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
            sendMail.sendEmailToForgotPassword(email, resetPasswordLink);
            model.addAttribute("message", "Ti-am trimis un mail cu resetarea parolei! ");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "login/forgot_password_form";
    }


    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) throws MessagingException, UnsupportedEncodingException {
        Optional<User> optionalUser = userService.getByResetPasswordToken(token);
        if(optionalUser.isEmpty()){
            model.addAttribute("message", "Invalid Token");
            return "message";
        }
        sendMail.sendEmailToResetPassword(optionalUser.get().getEmail());
        model.addAttribute("token", token);

        return "login/reset_password_form";

    }
    @PostMapping("/reset_password")
    public String processResetPassword(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        Optional<User> optionalUser = userService.getByResetPasswordToken(token);
        model.addAttribute("title", "Reset your password");
        if(optionalUser.isEmpty()){
            model.addAttribute("message", "Invalid Token");
            return "message";
        }
        else{
            User user = optionalUser.get();
            userService.updatePassword(user, password);
            return "redirect:/login";
        }
    }
}
