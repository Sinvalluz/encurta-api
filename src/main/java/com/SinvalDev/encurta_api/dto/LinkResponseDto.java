package com.SinvalDev.encurta_api.dto;

import java.time.LocalDateTime;

public record LinkResponseDto(Long id, String originalUrl, String shortCode, LocalDateTime creationDate) {
}
