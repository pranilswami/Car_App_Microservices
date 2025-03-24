package com.car_app.car_service.car_service.controller;

import com.car_app.car_service.car_service.entity.Brand;
import com.car_app.car_service.car_service.payload.BrandDto;
import com.car_app.car_service.car_service.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Brand>> getAllBrands() {
        return new ResponseEntity<>(brandService.getAllBrands(), HttpStatus.OK);
    }

    @PostMapping("/addBrand")
    public ResponseEntity<Brand> addBrand(@RequestBody BrandDto brandDto) {
        return new ResponseEntity<>(brandService.addBrand(brandDto),HttpStatus.CREATED);
    }
}
