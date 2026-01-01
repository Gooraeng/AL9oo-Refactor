package com.back.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@RequiredArgsConstructor
@Getter
public enum ErrorDetails {

    // Common
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "COM001", "Invalid input"),
    INVALID_TYPE(HttpStatus.BAD_REQUEST, "COM002", "Invalid type"),
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "COM003", "Access Denied"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COM004", "Internal server error"),

    // Car
    CAR_NOT_FOUND(HttpStatus.NOT_FOUND, "CAR001", "Car not found"),
    CAR_EXISTS(HttpStatus.CONFLICT, "CAR002", "Car already exists"),
    CAR_DELETED(HttpStatus.CONFLICT, "CAR003", "Car was already deleted"),
    // Manufacturer

    MANUFACTURER_NOT_FOUND(HttpStatus.NOT_FOUND, "MAN001", "Manufacturer not found"),
    MANUFACTURER_EXISTS(HttpStatus.CONFLICT, "MAN002", "Duplicate manufacturer"),
    MANUFACTURER_HAS_CARS(HttpStatus.CONFLICT, "MAN003", "Cannot delete manufacturer with existing cars");

    // Track

    // User

    // Reference
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
