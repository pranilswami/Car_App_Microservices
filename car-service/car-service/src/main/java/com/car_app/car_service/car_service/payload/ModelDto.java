package com.car_app.car_service.car_service.payload;

public class ModelDto {
    private String modelName;

    public ModelDto(){}

    public ModelDto(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
