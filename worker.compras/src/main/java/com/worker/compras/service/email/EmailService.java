package com.worker.compras.service.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    public void notifyClient(String email) {
        var msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("Purchase received");
        msg.setText("We are preparing your preparing your invoice , just wait some minutes ...");
        javaMailSender.send(msg);
        log.info("Message sent successful");
    }
}
