package com.car_app.car_service.car_service.repository;

import com.car_app.car_service.car_service.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Long> {
  List<Model> findByBrandId(Long brandId);
  @Query("SELECT m FROM Model m WHERE m.modelName =:modelName")
  Optional<Model> findByModelName(@Param("modelName") String modelName);
}