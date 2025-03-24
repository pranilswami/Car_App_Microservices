package com.car_app.order_service.order_service.feign_client;

import com.car_app.order_service.order_service.payload.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping(path = "/api/v1/users/getUserById/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    UserDto getUserById(@PathVariable Long userId);
}
