package com.car_app.car_service.car_service.repository;

import com.car_app.car_service.car_service.entity.Year;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearRepository extends JpaRepository<Year, Long> {
}