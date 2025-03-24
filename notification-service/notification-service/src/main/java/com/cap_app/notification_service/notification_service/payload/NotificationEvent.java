package com.cap_app.notification_service.notification_service.payload;

import java.io.Serializable;

public class NotificationEvent implements Serializable {
    private String recipientEmail;
    private String subject;
    private String message;

    public NotificationEvent() {}

    public NotificationEvent(String recipientEmail, String subject, String message) {
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.message = message;
    }

    public String getRecipientEmail() { return recipientEmail; }
    public void setRecipientEmail(String recipientEmail) { this.recipientEmail = recipientEmail; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
