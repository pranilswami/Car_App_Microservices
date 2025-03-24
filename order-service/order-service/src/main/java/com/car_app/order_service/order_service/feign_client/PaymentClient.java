package com.car_app.order_service.order_service.feign_client;


import com.car_app.order_service.order_service.payload.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service")
public interface PaymentClient {
    @PostMapping(path = "/api/v1/payments/processPayment",consumes = MediaType.APPLICATION_JSON_VALUE)
    PaymentDto processPayment(@RequestBody PaymentDto paymentDto);
}