package com.car_app.car_service.car_service.controller;

import com.car_app.car_service.car_service.entity.FuelType;
import com.car_app.car_service.car_service.payload.FuelTypeDto;
import com.car_app.car_service.car_service.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fuel-types")
public class FuelTypeController {

    @Autowired
    private FuelTypeService fuelTypeService;

    @GetMapping("/getAll")
    public ResponseEntity<List<FuelType>> getAllFuelTypes() {
        return new ResponseEntity<>(fuelTypeService.getAllFuelTypes(), HttpStatus.OK);
    }

    @PostMapping("/addFuelType")
    public ResponseEntity<FuelType> addFuelType(@RequestBody FuelTypeDto fuelTypeDto) {
        return new ResponseEntity<>(fuelTypeService.addFuelType(fuelTypeDto),HttpStatus.CREATED);
    }
}
