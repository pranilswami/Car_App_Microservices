package com.car_app.order_service.order_service.feign_client;

import com.car_app.order_service.order_service.payload.NotificationEvent;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "notification-service")
public interface NotificationClient {
    @PostMapping(path = "/api/v1/notifications/send",consumes = MediaType.APPLICATION_JSON_VALUE)
    void sendNotification(@RequestBody NotificationEvent event);
}
