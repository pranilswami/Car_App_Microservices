package com.car_app.order_service.order_service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class NotificationEvent implements Serializable {
    @JsonProperty("recipientEmail")
    private String recipientEmail;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("message")
    private String message;

    public NotificationEvent() {}

    public NotificationEvent(String recipientEmail, String subject,String message){
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.message = message;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
