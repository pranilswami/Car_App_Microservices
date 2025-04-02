package com.car_app.car_service.car_service.repository;

import com.car_app.car_service.car_service.entity.Transmission;
import com.car_app.car_service.car_service.entity.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface YearRepository extends JpaRepository<Year, Long> {
    @Query("SELECT y FROM Year y WHERE y.year =:year")
    Optional<Year> findByYear(@Param("year") String year);
}