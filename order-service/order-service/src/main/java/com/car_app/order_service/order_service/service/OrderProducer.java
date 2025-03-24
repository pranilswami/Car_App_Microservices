package com.car_app.order_service.order_service.service;

import com.car_app.order_service.order_service.entity.Order;
import com.car_app.order_service.order_service.payload.NotificationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    @Autowired
    private KafkaTemplate<String, NotificationEvent> kafkaTemplate;

    public void sendOrderEvent(String email, String message){
        NotificationEvent event = new NotificationEvent(email,"Order Confirmation",message);
        kafkaTemplate.send("order-notifications",event);
    }
}
