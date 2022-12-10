package com.it_components_store.mail;

import com.it_components_store.dto.ShoppingCartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SendMail {
    private final JavaMailSender mailSender;

    public void sendEmailToOrder(String recipientEmail,  List<ShoppingCartDto> shoppingCartDtoList) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("Insert your email", "IT components Store ");
        helper.setTo(recipientEmail);

        String subject = "Multumim pentru comanda!";
        StringBuilder content = new StringBuilder("<p>Salut,</p>"
                + "<p> Detaliile comenzii.</p>");

        for(ShoppingCartDto shoppingCartDto: shoppingCartDtoList){
            content.append("<p> ").append(shoppingCartDto.getDescription()).append(".  cantitate:").append(shoppingCartDto.getQuantity()).append("</p>");

        }
        content.append("<p> Echipa IT components va multumeste ! </p> ");

        helper.setSubject(subject);

        helper.setText(content.toString(), true);
        mailSender.send(message);

    }

    public void sendEmailToForgotPassword(String recipientEmail, String link)  throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("Insert your email", "IT components Support ");
        helper.setTo(recipientEmail);

        String subject = "Iată linkul pentru a vă reseta parola";

        String content = "<p>Salut,</p>"
                + "<p>Ați solicitat să vă resetați parola.</p>"
                + "<p>Faceți clic pe linkul de mai jos pentru a vă schimba parola:</p>"
                + "<p><a href=\"" + link + "\">Reseteaza parola</a></p>"
                + "<br>"
                + "<p>Ignorați acest e-mail dacă vă amintiți parola,"
                + "sau daca nu ati facut solicitarea.</p>";


        helper.setSubject(subject);

        helper.setText(content, true);
        mailSender.send(message);
    }

    public void sendEmailToResetPassword(String recipientEmail)  throws MessagingException, UnsupportedEncodingException{
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("Insert your email", "IT components Support ");
        helper.setTo(recipientEmail);

        String subject = "Alerta de securitate";

        String content = "<p>Salut,</p>"
                + "<p>Tocmai s-a schimbat parola la contul dvs.</p>"
                + "<p>In caz de nu ai resetat tu  parola, te rugam sa schimbi cat mai repede  datele de conectare !</p>"
                + "<br>";


        helper.setSubject(subject);

        helper.setText(content, true);
        mailSender.send(message);
    }


}
