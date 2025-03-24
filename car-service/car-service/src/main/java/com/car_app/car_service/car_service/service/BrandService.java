package com.car_app.car_service.car_service.service;

import com.car_app.car_service.car_service.entity.Brand;
import com.car_app.car_service.car_service.payload.BrandDto;
import com.car_app.car_service.car_service.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand addBrand(BrandDto brandDto) {
        Optional<Brand> opBrand = brandRepository.findByBrandName(brandDto.getBrandName());
        if(opBrand.isPresent()){
            throw new RuntimeException("BRAND NAME IS ALREADY EXISTS");
        }
        Brand brand = new Brand();
        brand.setBrandName(brandDto.getBrandName());
        return brandRepository.save(brand);
    }
}
