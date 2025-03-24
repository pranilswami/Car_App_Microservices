package com.car_app.order_service.order_service.payload;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)  // Null properties JSON response me nahi aayengi
public class PaymentDto {
    private Long orderId;
    private Double amount;
    private Long paymentStatusId;
    private Long paymentMethodId;
    private String message;

    public PaymentDto(){}
    public PaymentDto(Long orderId,Double amount,Long paymentStatusId,Long paymentMethodId){
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethodId = paymentMethodId;
        this.paymentStatusId = paymentMethodId;
    }

    public PaymentDto(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

