//package com.cap_app.notification_service.notification_service.service;
//
//import com.cap_app.notification_service.notification_service.payload.NotificationEvent;
//import com.cap_app.notification_service.notification_service.payload.PaymentEvent;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Service;
//
//@Service
//public class NotificationConsumer {
//    @Autowired
//    private NotificationService notificationService;
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @KafkaListener(topics = "order-notifications", groupId = "notification-group",containerFactory = "notificationKafkaListenerContainerFactory")
//    public void consume(@Payload NotificationEvent notificationEvent){
//        System.out.println(notificationEvent.getRecipientEmail()+" "+notificationEvent.getMessage()+" "+notificationEvent.getSubject());// this notification is coming from the kafka producer from order-service
//        notificationService.sendEmail(notificationEvent);
//    }
//
////    @KafkaListener(topics = "payment-topic", groupId = "notification-group",containerFactory = "paymentKafkaListenerContainerFactory")
////    public void consumePaymentNotification(@Payload PaymentEvent event) {
////        System.out.println("Received payment notification: " + event);
////        notificationService.sendEmailForPayment(event);
////    }
//
//    @KafkaListener(topics = "payment-topic", groupId = "notification-group",containerFactory = "paymentKafkaListenerContainerFactory")
//    public void consumePaymentNotification(ConsumerRecord<String, String> record) {
//        try {
//            // Convert JSON string to PaymentEvent object manually
//            PaymentEvent event = objectMapper.readValue(record.value(), PaymentEvent.class);
//            System.out.println("🔔 Received Payment Notification: " + event);
//            notificationService.sendEmailForPayment(event);
//        } catch (Exception e) {
//            System.err.println("❌ Error deserializing Kafka message: " + e.getMessage());
//        }
//
//    }
//
//
//}
