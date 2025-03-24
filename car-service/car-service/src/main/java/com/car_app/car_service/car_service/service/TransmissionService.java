package com.car_app.car_service.car_service.service;

import com.car_app.car_service.car_service.entity.Transmission;
import com.car_app.car_service.car_service.payload.TransmissionDto;
import com.car_app.car_service.car_service.repository.TransmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransmissionService {
    @Autowired
    private TransmissionRepository transmissionRepository;

    public List<Transmission> getAllTransmissions() {
        return transmissionRepository.findAll();
    }

    public Transmission addTransmission(TransmissionDto transmissionDto) {
        Optional<Transmission> opTransmission = transmissionRepository.findByTransmissionType(transmissionDto.getType());
        if (opTransmission.isPresent()){
            throw new RuntimeException("TRANSMISSION TYPE IS ALREADY EXISTS");
        }
        Transmission transmission = new Transmission();
        transmission.setType(transmissionDto.getType());
        return transmissionRepository.save(transmission);
    }
}
