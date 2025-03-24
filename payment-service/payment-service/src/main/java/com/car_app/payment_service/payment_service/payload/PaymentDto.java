package com.car_app.payment_service.payment_service.payload;

import com.car_app.payment_service.payment_service.entity.PaymentMethod;
import com.car_app.payment_service.payment_service.entity.PaymentStatus;

public class PaymentDto {
    private Long orderId;
    private Double amount;
    private Long paymentStatusId;
    private Long paymentMethodId;

    public PaymentDto(){}
    public PaymentDto(Long orderId,Double amount,Long paymentStatusId,Long paymentMethodId){
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethodId = paymentMethodId;
        this.paymentStatusId = paymentMethodId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getPaymentStatusId() {
        return paymentStatusId;
    }

    public void setPaymentStatusId(Long paymentStatusId) {
        this.paymentStatusId = paymentStatusId;
    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
}
