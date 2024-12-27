package com.spring_fundamentals.ExamenFundamentals.exception.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record ApiError(
        @JsonProperty(value = "status_code")
        int statusCode,
        String message,
        LocalDateTime time) {
}
