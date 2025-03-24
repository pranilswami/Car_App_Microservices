package com.car_app.car_service.car_service.service;

import com.car_app.car_service.car_service.entity.CarStatus;
import com.car_app.car_service.car_service.payload.CarStatusDto;
import com.car_app.car_service.car_service.repository.CarStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarStatusService {
    @Autowired
    private CarStatusRepository carStatusRepository;

    public List<CarStatus> getAllCarStatuses() {
        return carStatusRepository.findAll();
    }

    public CarStatus addCarStatus(CarStatusDto carStatusDto) {
        Optional<CarStatus> opCarStatus = carStatusRepository.findByName(carStatusDto.getStatus());
        if(opCarStatus.isPresent()){
            throw new RuntimeException("STATUS IS ALREADY EXISTS");
        }
        CarStatus carStatus = new CarStatus();
        carStatus.setStatus(carStatusDto.getStatus());
        return carStatusRepository.save(carStatus);
    }
}
