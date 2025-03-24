//package com.car_app.payment_service.payment_service.service;
//
//import com.car_app.payment_service.payment_service.config.AppConstants;
//import com.car_app.payment_service.payment_service.payload.PaymentEvent;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PaymentProducer {
//    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;
//
//    private final Logger logger = LoggerFactory.getLogger(PaymentProducer.class);
//
//    public PaymentProducer(KafkaTemplate<String, PaymentEvent> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void sendPaymentNotification(PaymentEvent event) {
//        this.logger.info("message produced");
//        this.kafkaTemplate.send(AppConstants.PAYMENT_TOPIC_NAME, event);
//    }
//}
