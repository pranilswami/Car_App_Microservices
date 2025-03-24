package com.car_app.car_service.car_service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrandDto {
    @JsonProperty("brandName")
    private String brandName;

    public BrandDto(){}

    public BrandDto(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
