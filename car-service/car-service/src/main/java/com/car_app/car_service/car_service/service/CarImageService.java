package com.car_app.car_service.car_service.service;

import com.car_app.car_service.car_service.entity.Brand;
import com.car_app.car_service.car_service.entity.CarImage;
import com.car_app.car_service.car_service.payload.CarImageDto;
import com.car_app.car_service.car_service.repository.CarImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarImageService {
    @Autowired
    private CarImageRepository carImageRepository;

    public List<CarImage> getImagesByCarId(Long carId) {
        return carImageRepository.findByCarId(carId);
    }

    public CarImage addCarImage(CarImageDto carImageDto) {
        CarImage carImage = new CarImage();
        carImage.setImageUrl(carImageDto.getImageUrl());
        return carImageRepository.save(carImage);
    }
}
