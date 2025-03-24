package com.car_app.order_service.order_service.feign_client;

import com.car_app.order_service.order_service.payload.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "car-service")
public interface CarClient {
    @GetMapping(path = "/api/v1/cars/getCarById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    CarDto getCarById(@PathVariable("id") Long id);
}
