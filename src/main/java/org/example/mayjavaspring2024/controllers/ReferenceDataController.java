package org.example.mayjavaspring2024.controllers;

import lombok.RequiredArgsConstructor;
import org.example.mayjavaspring2024.properties.Fuel;
import org.example.mayjavaspring2024.properties.ReferenceDataProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class ReferenceDataController {

    private final ReferenceDataProperties referenceDataProperties;

    @GetMapping("/engine-types")
    public ResponseEntity<List<String>> getEngineTypes() {
        return ResponseEntity.ok(referenceDataProperties.getEngineTypes());
    }

    @GetMapping("/fuel-types")
    public ResponseEntity<List<Fuel>> getFuelTypes() {
        return ResponseEntity.ok(referenceDataProperties.getFuels());
    }

    @GetMapping("/fuel-types/{name}")
    public ResponseEntity<Fuel> getFuelTypeByName(@PathVariable String name) {
        Optional<Fuel> fuelType = Optional.ofNullable(referenceDataProperties)
                .map(ReferenceDataProperties::getFuels)
                .stream()
                .flatMap(Collection::stream)
                .filter(fuel -> Objects.equals(fuel.getName(), name))
                .findFirst();
        return ResponseEntity.of(fuelType);
    }
}
