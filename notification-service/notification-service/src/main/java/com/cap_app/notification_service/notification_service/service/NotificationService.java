package com.cap_app.notification_service.notification_service.service;

import com.cap_app.notification_service.notification_service.payload.NotificationEvent;
import com.cap_app.notification_service.notification_service.payload.PaymentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(NotificationEvent event) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(event.getRecipientEmail());
        message.setSubject(event.getSubject());
        message.setText(event.getMessage());
        mailSender.send(message);
    }
    public void sendEmailForPayment(PaymentEvent event){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(event.getRecipientEmail());
        message.setSubject(event.getSubject());
        message.setText(event.getMessage());
        mailSender.send(message);
    }
}
