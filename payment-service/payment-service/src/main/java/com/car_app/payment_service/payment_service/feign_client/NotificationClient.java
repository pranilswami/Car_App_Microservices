package com.car_app.payment_service.payment_service.feign_client;

import com.car_app.payment_service.payment_service.payload.NotificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", path = "/api/v1/notifications")
public interface NotificationClient {
    @PostMapping("/send")
    void sendNotification(@RequestBody NotificationDto request);
}

