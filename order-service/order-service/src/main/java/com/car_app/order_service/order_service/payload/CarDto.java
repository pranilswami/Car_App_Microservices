package com.car_app.order_service.order_service.payload;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)  // Null properties JSON response me nahi aayengi
public class CarDto {
    private Long brandId;
    private Long fuelTypeId;
    private Long modelId;
    private Long transmissionId;
    private Long yearId;
    private Long statusId;
    private Double price;
    private String message;

    public CarDto(){}
    public CarDto(Long brandId, Long fuelTypeId, Long modelId, Long transmissionId, Long yearId, Long statusId, double price) {
        this.brandId = brandId;
        this.fuelTypeId = fuelTypeId;
        this.modelId = modelId;
        this.transmissionId = transmissionId;
        this.yearId = yearId;
        this.statusId = statusId;
        this.price = price;
    }


// Constructor for fallback
    public CarDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(Long fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getTransmissionId() {
        return transmissionId;
    }

    public void setTransmissionId(Long transmissionId) {
        this.transmissionId = transmissionId;
    }

    public Long getYearId() {
        return yearId;
    }

    public void setYearId(Long yearId) {
        this.yearId = yearId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}