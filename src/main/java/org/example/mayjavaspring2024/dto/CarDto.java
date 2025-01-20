package org.example.mayjavaspring2024.dto;

import lombok.Builder;

@Builder
public record CarDto(
        Long id,

        String model,

        Long enginePower,

        Double torque
) {
}
