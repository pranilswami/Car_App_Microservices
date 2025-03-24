package com.car_app.car_service.car_service.controller;

import com.car_app.car_service.car_service.entity.Car;
import com.car_app.car_service.car_service.payload.CarDto;
import com.car_app.car_service.car_service.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
    @Autowired
    private CarService carService;

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/getCarById/{id}")
    public CarDto getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping("/addCar")
    public ResponseEntity<Car> addCar(@RequestBody CarDto carDto) {
        logger.info("adding car..");
        return new ResponseEntity<>(carService.addCar(carDto),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>("Car deleted successfully",HttpStatus.OK);
    }
}
