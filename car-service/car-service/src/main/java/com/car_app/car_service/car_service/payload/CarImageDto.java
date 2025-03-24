package com.car_app.car_service.car_service.payload;

public class CarImageDto {
    private String imageUrl;

    public CarImageDto(){}

    public CarImageDto(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
