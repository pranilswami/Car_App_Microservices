package com.car_app.order_service.order_service.repository;

import com.car_app.order_service.order_service.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
}