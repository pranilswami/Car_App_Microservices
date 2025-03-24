package com.car_app.payment_service.payment_service.payload;

import java.io.Serializable;

public class PaymentEvent implements Serializable {
    private String email;
    private String message;
    private String subject;

    public PaymentEvent(){}

    public PaymentEvent(String email,String message,String subject){
        this.email = email;
        this.message = message;
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
