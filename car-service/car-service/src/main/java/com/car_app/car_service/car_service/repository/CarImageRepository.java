package com.car_app.car_service.car_service.repository;

import com.car_app.car_service.car_service.entity.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarImageRepository extends JpaRepository<CarImage, Long> {
    List<CarImage> findByCarId(Long carId);
}