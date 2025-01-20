package org.example.mayjavaspring2024.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.mayjavaspring2024.dto.CarDto;
import org.example.mayjavaspring2024.dto.CreateCarDto;
import org.example.mayjavaspring2024.entities.Car;
import org.example.mayjavaspring2024.mapper.CarMapper;
import org.example.mayjavaspring2024.repostitories.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    private final CarMapper carMapper;

    public List<CarDto> getAllCars(
            @RequestParam(name = "minEnginePower", required = false) Long minEnginePower,
            @RequestParam(name = "maxEnginePower", required = false) Long maxEnginePower
    ) {
        if (minEnginePower != null && maxEnginePower != null) {
            return carRepository.findByEnginePowerBetween(minEnginePower, maxEnginePower)
                    .stream()
                    .map(carMapper::mapCarToDto)
                    .toList();
        } else if (minEnginePower != null) {
            return carRepository.findByEnginePowerGreaterThan(minEnginePower)
                    .stream()
                    .map(carMapper::mapCarToDto)
                    .toList();
        } else if (maxEnginePower != null) {
            return carRepository.findByEnginePowerLessThan(maxEnginePower)
                    .stream()
                    .map(carMapper::mapCarToDto)
                    .toList();
        } else {
            return carRepository.findAll()
                    .stream()
                    .map(carMapper::mapCarToDto)
                    .toList();
        }
    }

    @Transactional
    public CarDto createCar(CreateCarDto createCarDto) {
        Car car = carRepository.save(new Car());
        car.setModel(createCarDto.model());
        car.setEnginePower(createCarDto.enginePower());
        car.setTorque(createCarDto.torque());
        return carMapper.mapCarToDto(car);
    }

    public CarDto getCarById(Long id) {
        return carMapper.mapCarToDto(carRepository.findById(id).orElse(null));
    }

    public CarDto updateCar(CreateCarDto createCarDto, Long id) {
        Car updateCar = carRepository.findById(id).orElse(null);
        if (updateCar != null) {
            updateCar.setModel(createCarDto.model());
            updateCar.setEnginePower(createCarDto.enginePower());
            updateCar.setTorque(createCarDto.torque());
            return carMapper.mapCarToDto(carRepository.save(updateCar));
        }
        return null;
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }


}
