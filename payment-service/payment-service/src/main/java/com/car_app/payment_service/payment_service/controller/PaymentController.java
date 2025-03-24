package com.car_app.payment_service.payment_service.controller;

import com.car_app.payment_service.payment_service.entity.Payment;
import com.car_app.payment_service.payment_service.payload.PaymentDto;
import com.car_app.payment_service.payment_service.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping("/getAll")
    public ResponseEntity<List<Payment>> getAllPayments(){
        logger.info("get all payments..");
        return new ResponseEntity<>(paymentService.getAllPayments(), HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<Payment>> getPaymentsByOrderId(@PathVariable Long orderId){
        logger.info("get payment by order id..");
        return new ResponseEntity<>(paymentService.getPaymentsByOrderId(orderId),HttpStatus.OK);
    }

    @GetMapping("/getPayment/{id}")
    public ResponseEntity<Payment> getPaymentId(@PathVariable Long id){
        logger.info("get payment by id..");
        return new ResponseEntity<>(paymentService.getPaymentById(id),HttpStatus.OK);
    }

    @PostMapping(path = "/processPayment",consumes = MediaType.APPLICATION_JSON_VALUE)
    public PaymentDto processPayment(@RequestBody PaymentDto paymentDto){
        logger.info("payment processing..");
        return paymentService.processPayment(paymentDto);
    }

    @DeleteMapping("/cancelPayment/{id}")
    public ResponseEntity<String> cancelPayment(@PathVariable Long id) {
        paymentService.cancelPayment(id);
        return new ResponseEntity<>("Payment cancelled successfully",HttpStatus.OK);
    }
}
