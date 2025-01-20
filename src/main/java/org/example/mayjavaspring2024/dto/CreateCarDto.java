package org.example.mayjavaspring2024.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateCarDto(

        @NotBlank
        String model,

        @Min(50)
        Long enginePower,

        @Min(70)
        Double torque
) {
}
