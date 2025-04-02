package com.car_app.car_service.car_service.controller;

import com.car_app.car_service.car_service.entity.Year;
import com.car_app.car_service.car_service.payload.YearDto;
import com.car_app.car_service.car_service.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/years")
public class YearController {
    @Autowired
    private YearService yearService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Year>> getAllYear(){
        return new ResponseEntity<>(yearService.getAllYear(),HttpStatus.OK);
    }

    @PostMapping("/addYear")
    public ResponseEntity<Year> addYear(@RequestBody YearDto yearDto){
        return new ResponseEntity<>(yearService.addYear(yearDto), HttpStatus.CREATED);
    }
}
