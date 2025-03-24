package com.car_app.car_service.car_service.payload;

public class CarStatusDto {
    private String status;

    public CarStatusDto(){}

    public CarStatusDto(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
