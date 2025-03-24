package com.cap_app.notification_service.notification_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cap_app.notification_service.notification_service.payload.NotificationEvent;
import com.cap_app.notification_service.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @PostMapping(path = "/send", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendNotification(@RequestBody NotificationEvent notification){
        notificationService.sendEmail(notification);
        logger.info("sending email..");
        return new ResponseEntity<>("Notification sent successfully!", HttpStatus.OK);
    }
}