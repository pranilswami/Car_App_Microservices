package com.car_app.order_service.order_service.payload;

import com.car_app.order_service.order_service.entity.OrderStatus;

public class OrderDto {
    private Long userId;
    private Long carId;
    private Long statusId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}
