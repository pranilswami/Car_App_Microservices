package com.car_app.car_service.car_service.controller;

import com.car_app.car_service.car_service.entity.CarImage;
import com.car_app.car_service.car_service.payload.CarImageDto;
import com.car_app.car_service.car_service.service.CarImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car-images")
public class CarImageController {

    @Autowired
    private CarImageService carImageService;

    @GetMapping("/getImage/{carId}")
    public ResponseEntity<List<CarImage>> getImagesByCarId(@PathVariable Long carId) {
        return new ResponseEntity<>(carImageService.getImagesByCarId(carId), HttpStatus.OK);
    }

    @PostMapping("/addCarImage")
    public ResponseEntity<CarImage> addCarImage(@RequestBody CarImageDto carImageDto) {
        return new ResponseEntity<>(carImageService.addCarImage(carImageDto),HttpStatus.CREATED);
    }
}
