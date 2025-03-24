package com.car_app.order_service.order_service.service;

import com.car_app.order_service.order_service.entity.Order;
import com.car_app.order_service.order_service.entity.OrderStatus;
import com.car_app.order_service.order_service.feign_client.CarClient;
import com.car_app.order_service.order_service.feign_client.NotificationClient;
import com.car_app.order_service.order_service.feign_client.PaymentClient;
import com.car_app.order_service.order_service.feign_client.UserClient;
import com.car_app.order_service.order_service.payload.*;
import com.car_app.order_service.order_service.repository.OrderRepository;
import com.car_app.order_service.order_service.repository.OrderStatusRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final OrderProducer orderProducer;
    private final NotificationClient notificationClient;
    private final UserClient userClient;
    private final CarClient carClient;
    private final PaymentClient paymentClient;

    @Autowired
    public OrderService(UserClient userClient,
                        NotificationClient notificationClient,
                        OrderProducer orderProducer,
                        OrderStatusRepository orderStatusRepository,
                        OrderRepository orderRepository, CarClient carClient, PaymentClient paymentClient) {
        this.userClient = userClient;
        this.notificationClient = notificationClient;
        this.orderProducer = orderProducer;
        this.orderStatusRepository = orderStatusRepository;
        this.orderRepository = orderRepository;
        this.carClient = carClient;
        this.paymentClient = paymentClient;
    }


    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public List<Order> getOrderByUserId(Long userId){
        return orderRepository.findByUserId(userId);
    }

    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElseThrow(()->new RuntimeException("ORDER NOT FOUND BY GIVEN ID"));
    }

    public Order placeOrder(OrderDto orderDto){

        OrderStatus orderStatus = orderStatusRepository.findById(orderDto.getStatusId()).orElseThrow(()->new RuntimeException("ORDER STATUS NOT FOUND BY GIVEN ID"));
        Order order = new Order();
        order.setCarId(orderDto.getCarId());
        order.setUserId(orderDto.getUserId());
        order.setStatus(orderStatus);

        Order savedOrder = orderRepository.save(order);  //getting the saved object

        // Create Notification Event
        NotificationEvent event = new NotificationEvent("pranilswami41400@gmail.com",
                "Order Confirmation",
                "Your order for car ID " + order.getCarId() + " has been placed.");

        System.out.println(event.getRecipientEmail()+" "+event.getMessage()+" "+event.getSubject());

        // Call Notification Service via REST API
        notificationClient.sendNotification(event);
        return savedOrder;
    }

    public void cancelOrder(Long id){
        orderRepository.deleteById(id);
    }


    @CircuitBreaker(name = "userService", fallbackMethod = "fallbackForUserService")
    public UserDto fetchUserDetails(Long userId) {
        log.info("INSIDE THE FETCH USER DETAILS------------------------------");
        UserDto userDto = userClient.getUserById(userId);
        System.out.println(userDto.getName()+" "+userDto.getEmailId()+" "+userDto.getUsername());
        return userDto;
    }
    public UserDto fallbackForUserService(Long userId, Throwable t) {
        return new UserDto("default", "User Service Unavailable");
    }


    @CircuitBreaker(name = "carService", fallbackMethod = "fallbackForCarService")
    public CarDto fetchCarDetails(Long carId) {
        return carClient.getCarById(carId);
    }
    public CarDto fallbackForCarService(Long userId, Throwable t){
        return new CarDto("default","Car Service Unavailable");
    }


// Process Payments
    @Retry(name = "paymentService", fallbackMethod = "fallbackForPaymentService")
    public PaymentDto makePayment(PaymentDto paymentDto) {
        return paymentClient.processPayment(paymentDto);
    }
    public String fallbackForPaymentService(PaymentDto paymentDto, Throwable t){
        return "Payment Service is currently unavailable. Please try again later.";
    }


    @RateLimiter(name = "notificationService", fallbackMethod = "fallbackForRateLimit")
    public void sendNotification(NotificationEvent event){
        notificationClient.sendNotification(event);
    }
    public String fallbackForRateLimit(NotificationEvent event, Throwable t){
        return "Too many requests. Try again later.";
    }

}
