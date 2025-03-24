package com.car_app.car_service.car_service.service;

import com.car_app.car_service.car_service.entity.*;
import com.car_app.car_service.car_service.payload.CarDto;
import com.car_app.car_service.car_service.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private BrandRepository brandRepo;
    @Autowired
    private ModelRepository modelRepo;
    @Autowired
    private TransmissionRepository transmissionRepo;
    @Autowired
    private FuelTypeRepository fuelTypeRepo;
    @Autowired
    private YearRepository yearRepo;
    @Autowired
    private CarStatusRepository carStatusRepo;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public CarDto getCarById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(()->new RuntimeException("CAR NOT FOUND WITH GIVEN ID"));

        CarDto carDto = new CarDto();
        carDto.setBrandId(car.getBrand().getId());
        carDto.setPrice(car.getPrice());
        carDto.setModelId(car.getModel().getId());
        carDto.setFuelTypeId(car.getFuelType().getId());
        carDto.setStatusId(car.getStatus().getId());
        carDto.setTransmissionId(car.getTransmission().getId());
        carDto.setYearId(car.getYear().getId());
        return carDto;
    }

    public Car addCar(CarDto carDto) {
        Brand brand = brandRepo.findById(carDto.getBrandId()).orElseThrow(()->new RuntimeException("Brand not found"));
        Model model = modelRepo.findById(carDto.getModelId()).orElseThrow(()->new RuntimeException("Model not found"));
        Transmission transmission = transmissionRepo.findById(carDto.getTransmissionId()).orElseThrow(()->new RuntimeException("Transmission not found"));
        FuelType fuelType = fuelTypeRepo.findById(carDto.getFuelTypeId()).orElseThrow(()->new RuntimeException("FuelType not found"));
        Year year = yearRepo.findById(carDto.getYearId()).orElseThrow(()->new RuntimeException("Year not found"));
        CarStatus status = carStatusRepo.findById(carDto.getStatusId()).orElseThrow(()->new RuntimeException("Status not found"));

        Car car = new Car();
        car.setBrand(brand);
        car.setFuelType(fuelType);
        car.setYear(year);
        car.setModel(model);
        car.setTransmission(transmission);
        car.setStatus(status);
        car.setPrice(carDto.getPrice());
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
