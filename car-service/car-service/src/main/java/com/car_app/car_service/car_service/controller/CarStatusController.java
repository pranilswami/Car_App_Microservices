package com.car_app.car_service.car_service.controller;

import com.car_app.car_service.car_service.entity.CarStatus;
import com.car_app.car_service.car_service.payload.CarStatusDto;
import com.car_app.car_service.car_service.service.CarStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car-status")
public class CarStatusController {

    @Autowired
    private CarStatusService carStatusService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CarStatus>> getAllCarStatuses() {
        return new ResponseEntity<>(carStatusService.getAllCarStatuses(), HttpStatus.OK);
    }

    @PostMapping("/addCarStatus")
    public ResponseEntity<CarStatus> addCarStatus(@RequestBody CarStatusDto carStatusDto) {
        return new ResponseEntity<>(carStatusService.addCarStatus(carStatusDto),HttpStatus.CREATED);
    }
}
