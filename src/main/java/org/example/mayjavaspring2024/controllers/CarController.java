package org.example.mayjavaspring2024.controllers;

import lombok.RequiredArgsConstructor;
import org.example.mayjavaspring2024.entities.Car;
import org.example.mayjavaspring2024.repostitories.CarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarRepository carRepository;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars(
            @RequestParam(name = "minEnginePower", required = false) Long minEnginePower,
            @RequestParam(name = "maxEnginePower", required = false) Long maxEnginePower
    ) {
        if (minEnginePower != null && maxEnginePower != null) {
            return ResponseEntity.ok(carRepository.findByEnginePowerBetween(minEnginePower, maxEnginePower));
        } else if (minEnginePower != null) {
            return ResponseEntity.ok(carRepository.findByEnginePowerGreaterThan(minEnginePower));
        } else if (maxEnginePower != null) {
            return ResponseEntity.ok(carRepository.findByEnginePowerLessThan(maxEnginePower));
        } else {
            return ResponseEntity.ok(carRepository.findAll());
        }
    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        return ResponseEntity.ok(carRepository.findById(id).orElse(null));
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        Car updateCar = carRepository.findById(id).orElse(null);
        if (updateCar != null) {
            updateCar.setEnginePower(car.getEnginePower());
            updateCar.setModel(car.getModel());
            return ResponseEntity.ok(carRepository.save(updateCar));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
