package com.studyGuide.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    // Values
    @Value("${spring.mail.username}")
    private String sender;

     public String sendEmail(String recipient, String subject, String message) {
         try {

             SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
             simpleMailMessage.setFrom(sender);
             simpleMailMessage.setTo(recipient);
             simpleMailMessage.setSubject(subject);
             simpleMailMessage.setText(message);
             javaMailSender.send(simpleMailMessage);

             return "success";
         } catch (Exception c) {
             return "cannot send email: " + c.getLocalizedMessage();
         }

     }

}
