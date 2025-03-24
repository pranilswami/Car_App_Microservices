package com.car_app.car_service.car_service.repository;

import com.car_app.car_service.car_service.entity.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TransmissionRepository extends JpaRepository<Transmission, Long> {
    @Query("SELECT t FROM Transmission t WHERE t.type =:transmissionType")
    Optional<Transmission> findByTransmissionType(@Param("transmissionType") String transmissionType);
}