package org.example.mayjavaspring2024.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.mayjavaspring2024.dto.CarDto;
import org.example.mayjavaspring2024.dto.CreateCarDto;
import org.example.mayjavaspring2024.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars(
            @RequestParam(name = "minEnginePower", required = false) Long minEnginePower,
            @RequestParam(name = "maxEnginePower", required = false) Long maxEnginePower
    ) {
            return ResponseEntity.ok(carService.getAllCars(minEnginePower, maxEnginePower));

    }

    @PostMapping("/cars")
    public ResponseEntity<CarDto> addCar(@Valid @RequestBody CreateCarDto createCarDto) {
        return ResponseEntity.ok(carService.createCar(createCarDto));
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Long id, @Valid @RequestBody CreateCarDto createCarDto) {
        if (carService.updateCar(createCarDto, id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carService.updateCar(createCarDto, id));
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }
}
