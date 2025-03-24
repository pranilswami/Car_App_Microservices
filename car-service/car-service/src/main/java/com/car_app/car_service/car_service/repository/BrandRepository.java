package com.car_app.car_service.car_service.repository;

import com.car_app.car_service.car_service.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("SELECT b FROM Brand b WHERE b.brandName =:brand")
    Optional<Brand> findByBrandName(@Param("brand") String brand);
}