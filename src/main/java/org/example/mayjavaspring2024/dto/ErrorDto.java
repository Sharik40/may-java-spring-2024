package org.example.mayjavaspring2024.dto;

import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
public record ErrorDto(String message, OffsetDateTime time) {
}
