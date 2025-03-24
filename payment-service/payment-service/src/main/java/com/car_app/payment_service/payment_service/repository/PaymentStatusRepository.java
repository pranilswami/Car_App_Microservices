package com.car_app.payment_service.payment_service.repository;

import com.car_app.payment_service.payment_service.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Long> {
}