package com.car_app.car_service.car_service.controller;

import com.car_app.car_service.car_service.entity.Transmission;
import com.car_app.car_service.car_service.payload.TransmissionDto;
import com.car_app.car_service.car_service.service.TransmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transmissions")
public class TransmissionController {

    @Autowired
    private TransmissionService transmissionService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Transmission>> getAllTransmissions() {
        return new ResponseEntity<>(transmissionService.getAllTransmissions(), HttpStatus.OK);
    }

    @PostMapping("/addTransmission")
    public ResponseEntity<Transmission> addTransmission(@RequestBody TransmissionDto transmissionDto) {
        return new ResponseEntity<>(transmissionService.addTransmission(transmissionDto),HttpStatus.CREATED);
    }
}

