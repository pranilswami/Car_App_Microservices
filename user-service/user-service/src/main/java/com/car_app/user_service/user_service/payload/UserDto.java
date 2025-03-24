package com.car_app.user_service.user_service.payload;

public class UserDto {
    private String name;
    private String username;
    private String emailId;

    public UserDto(){}
    public UserDto(String name,String username,String emailId){
        this.name = name;
        this.username = username;
        this.emailId = emailId;
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
