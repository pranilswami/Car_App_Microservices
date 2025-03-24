package com.car_app.payment_service.payment_service.service;

import com.car_app.payment_service.payment_service.entity.Payment;
import com.car_app.payment_service.payment_service.entity.PaymentMethod;
import com.car_app.payment_service.payment_service.entity.PaymentStatus;
import com.car_app.payment_service.payment_service.feign_client.NotificationClient;
import com.car_app.payment_service.payment_service.payload.NotificationDto;
import com.car_app.payment_service.payment_service.payload.PaymentDto;
import com.car_app.payment_service.payment_service.payload.PaymentEvent;
import com.car_app.payment_service.payment_service.repository.PaymentMethodRepository;
import com.car_app.payment_service.payment_service.repository.PaymentRepository;
import com.car_app.payment_service.payment_service.repository.PaymentStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentStatusRepository paymentStatusRepository;
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    private final NotificationClient notificationClient;

//    private final PaymentProducer paymentProducer;

    public PaymentService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
//        this.paymentProducer = paymentProducer;
    }

    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    public List<Payment> getPaymentsByOrderId(Long orderId){
        return paymentRepository.findByOrderId(orderId);
    }

    public Payment getPaymentById(Long id){
        return paymentRepository.findById(id).orElseThrow(()->new RuntimeException("PAYMENT NOT FOUND WITH GIVEN ID"));
    }

    public PaymentDto processPayment(PaymentDto paymentDto){
        PaymentStatus paymentStatus = paymentStatusRepository.findById(paymentDto.getPaymentStatusId()).orElseThrow(()->new RuntimeException("PAYMENT STATUS NOT FOUND BY GIVEN ID"));
        PaymentMethod paymentMethod = paymentMethodRepository.findById(paymentDto.getPaymentMethodId()).orElseThrow(()->new RuntimeException("PAYMENT METHOD NOT FOUND BY GIVEN ID"));
        Payment payment = new Payment();
        payment.setOrderId(paymentDto.getOrderId());
        payment.setAmount(paymentDto.getAmount());
        payment.setPaymentMethod(paymentMethod);
        payment.setPaymentStatus(paymentStatus);

        paymentRepository.save(payment);

        NotificationDto notificationDto = notificationDetails(); // Hardcoded notification by calling method
        sendPaymentNotification(notificationDto); // sending payment confirmation notification
        return paymentDto;
    }

    public void cancelPayment(Long id){
        paymentRepository.deleteById(id);
    }

//    send notification using Notification client
    public void sendPaymentNotification(NotificationDto request) {
        notificationClient.sendNotification(request);
    }

    public NotificationDto notificationDetails(){
        NotificationDto dto = new NotificationDto();
        dto.setRecipientEmail("pranilswami41400@gmail.com");
        dto.setSubject("Payment Confirmation");
        dto.setMessage("Payment completed Successfully");
        return dto;
    }

}
