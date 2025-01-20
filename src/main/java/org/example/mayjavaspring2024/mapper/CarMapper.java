package org.example.mayjavaspring2024.mapper;

import org.example.mayjavaspring2024.dto.CarDto;
import org.example.mayjavaspring2024.entities.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDto mapCarToDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .model(car.getModel())
                .enginePower(car.getEnginePower())
                .torque(car.getTorque())
                .build();
    }
}
