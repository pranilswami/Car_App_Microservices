package com.car_app.car_service.car_service.payload;

public class TransmissionDto {
    private String type;

    public TransmissionDto(){}

    public TransmissionDto(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
