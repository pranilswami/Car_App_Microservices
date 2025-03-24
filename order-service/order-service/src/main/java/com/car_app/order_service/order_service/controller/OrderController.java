package com.car_app.order_service.order_service.controller;

import com.car_app.order_service.order_service.entity.Order;
import com.car_app.order_service.order_service.payload.*;
import com.car_app.order_service.order_service.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/getAll")
    public ResponseEntity<List<Order>> getAllOrder(){
        logger.info("getting list of all orders...");
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId){
        logger.info("getting list of orders by user id...");
        return new ResponseEntity<>(orderService.getOrderByUserId(userId),HttpStatus.OK);
    }

    @GetMapping("/getOrder/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        logger.info("getting order by id...");
        return new ResponseEntity<>(orderService.getOrderById(id),HttpStatus.OK);
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<Order> placeOrder(@RequestBody OrderDto orderDto){
        logger.info("Processing Order...");
        return new ResponseEntity<>(orderService.placeOrder(orderDto),HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id){
        orderService.cancelOrder(id);
        return new ResponseEntity<>("Order cancelled successfully",HttpStatus.OK);
    }

    @GetMapping("/userDetails/{userId}")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable("userId") Long userId) {
        logger.info("getting user details by user id...");
        return orderService.fetchUserDetails(userId);
    }

    @GetMapping("/getCarById/{carId}")
    public CarDto getCarDetails(@PathVariable("carId") Long carId){
        logger.info("getting car details by car id...");
        return orderService.fetchCarDetails(carId);
    }

    @PostMapping("/processPayment")
    public PaymentDto processPayment(@RequestBody PaymentDto paymentDto){
        logger.info("processing payment...");
        return orderService.makePayment(paymentDto);
    }

    @PostMapping("/sendNotification")
    public void sendNotification(@RequestBody NotificationEvent event){
        logger.info("sending notification...");
        orderService.sendNotification(event);
    }

}
