package com.car_app.car_service.car_service.service;

import com.car_app.car_service.car_service.entity.FuelType;
import com.car_app.car_service.car_service.payload.FuelTypeDto;
import com.car_app.car_service.car_service.repository.FuelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuelTypeService {
    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    public List<FuelType> getAllFuelTypes() {
        return fuelTypeRepository.findAll();
    }

    public FuelType addFuelType(FuelTypeDto fuelTypeDto) {
        Optional<FuelType> opFuelType = fuelTypeRepository.findByFuelType(fuelTypeDto.getFuelType());
        if(opFuelType.isPresent()){
            throw new RuntimeException("FUEL TYPE IS ALREADY EXISTS");
        }
        FuelType fuelType = new FuelType();
        fuelType.setFuelType(fuelTypeDto.getFuelType());
        return fuelTypeRepository.save(fuelType);
    }
}
