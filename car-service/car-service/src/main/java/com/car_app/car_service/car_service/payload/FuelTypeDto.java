package com.car_app.car_service.car_service.payload;

public class FuelTypeDto {
    private String fuelType;

    public FuelTypeDto(){}

    public FuelTypeDto(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
