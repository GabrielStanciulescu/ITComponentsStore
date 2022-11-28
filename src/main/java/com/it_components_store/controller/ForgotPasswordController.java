package com.it_components_store.controller;

import com.it_components_store.entity.User;
import com.it_components_store.mail.Utility;
import com.it_components_store.service.UserService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ForgotPasswordController {
    private final UserService userService;
    private final JavaMailSender mailSender;
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
            sendEmail(email, resetPasswordLink);
            model.addAttribute("message", "Ti-am trimis un mail cu resetarea parolei! ");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "login/forgot_password_form";
    }

    public void sendEmail(String recipientEmail, String link)  throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("Insert your email for sending ", "IT components Support ");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);
        mailSender.send(message);
    }
    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
        Optional<User> optionalUser = userService.getByResetPasswordToken(token);
        if(optionalUser.isEmpty()){
            model.addAttribute("message", "Invalid Token");
            return "message";
        }
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
