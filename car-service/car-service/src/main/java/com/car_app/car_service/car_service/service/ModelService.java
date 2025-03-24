package com.car_app.car_service.car_service.service;

import com.car_app.car_service.car_service.entity.Model;
import com.car_app.car_service.car_service.payload.ModelDto;
import com.car_app.car_service.car_service.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;

    public List<Model> getModelsByBrand(Long brandId) {
        return modelRepository.findByBrandId(brandId);
    }

    public Model addModel(ModelDto modelDto) {
        Optional<Model> opModel = modelRepository.findByModelName(modelDto.getModelName());
        if (opModel.isPresent()){
            throw new RuntimeException("MODEL IS ALREADY EXISTS");
        }
        Model model = new Model();
        model.setModelName(modelDto.getModelName());
        return modelRepository.save(model);
    }
}
