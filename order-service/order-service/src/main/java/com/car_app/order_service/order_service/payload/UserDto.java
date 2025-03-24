package com.car_app.order_service.order_service.payload;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)  // Null properties JSON response me nahi aayengi
public class UserDto {
    private String name;
    private String username;
    private String emailId;
    private String message;

    public UserDto(){}
    public UserDto(String name,String username,String emailId){
        this.name = name;
        this.username = username;
        this.emailId = emailId;
    }

    //    Returning fall back message using constructor
    public UserDto(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
