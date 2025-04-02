package com.car_app.car_service.car_service.payload;

public class YearDto {
    private String year;

    public YearDto(){}
    public YearDto(String year){
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
