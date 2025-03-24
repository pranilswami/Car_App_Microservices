package com.car_app.car_service.car_service.controller;

import com.car_app.car_service.car_service.entity.Model;
import com.car_app.car_service.car_service.payload.ModelDto;
import com.car_app.car_service.car_service.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping("/brand/{brandId}")
    public ResponseEntity<List<Model>> getModelsByBrand(@PathVariable Long brandId) {
        return new ResponseEntity<>(modelService.getModelsByBrand(brandId), HttpStatus.OK);
    }

    @PostMapping("/addModel")
    public ResponseEntity<Model> addModel(@RequestBody ModelDto modelDto) {
        return new ResponseEntity<>(modelService.addModel(modelDto),HttpStatus.CREATED);
    }
}
