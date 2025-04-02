package com.car_app.car_service.car_service.service;

import com.car_app.car_service.car_service.entity.Year;
import com.car_app.car_service.car_service.payload.YearDto;
import com.car_app.car_service.car_service.repository.YearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YearService {
    @Autowired
    private YearRepository yearRepository;

    public Year addYear(YearDto yearDto){
        Optional<Year> opYear = yearRepository.findByYear(yearDto.getYear());
        if(opYear.isPresent()){
            throw new RuntimeException("YEAR IS ALREADY EXISTS");
        }
        Year year = new Year();
        year.setYear(yearDto.getYear());
        return yearRepository.save(year);
    }

    public List<Year> getAllYear() {
        return yearRepository.findAll();
    }
}
