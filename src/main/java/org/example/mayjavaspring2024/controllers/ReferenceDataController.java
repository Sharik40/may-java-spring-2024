package org.example.mayjavaspring2024.controllers;

import lombok.AllArgsConstructor;
import org.example.mayjavaspring2024.properties.ReferenceDataProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
//@AllArgsConstructor
public class ReferenceDataController {

    private final ReferenceDataProperties referenceDataProperties;

    public ReferenceDataController(ReferenceDataProperties referenceDataProperties) {
        this.referenceDataProperties = referenceDataProperties;
    }


    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/engine-types")
    public ResponseEntity<List<String>> getEngineTypes() {
        return ResponseEntity.ok(referenceDataProperties.getEngineTypes());
    }
}
