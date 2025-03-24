package com.car_app.car_service.car_service.repository;

import com.car_app.car_service.car_service.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
  List<Car> findByBrandId(Long brandId);
  List<Car> findByModelId(Long modelId);
  List<Car> findByFuelTypeId(Long fuelTypeId);
  List<Car> findByTransmissionId(Long transmissionId);
  List<Car> findByStatusId(Long statusId);
  List<Car> findByYearId(Long yearId);
}