package com.car_app.order_service.order_service.payload;

public class OrderResponse {
    private OrderDto orderDto;
    private UserDto userDto;
    private CarDto carDto;

    public OrderResponse(){}

    public OrderResponse(OrderDto orderDto, UserDto userDto, CarDto carDto) {
        this.orderDto = orderDto;
        this.userDto = userDto;
        this.carDto = carDto;
    }

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public CarDto getCarDto() {
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }
}
