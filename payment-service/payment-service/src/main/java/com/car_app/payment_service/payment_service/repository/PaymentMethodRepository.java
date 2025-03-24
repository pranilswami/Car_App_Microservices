package com.car_app.payment_service.payment_service.repository;

import com.car_app.payment_service.payment_service.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}