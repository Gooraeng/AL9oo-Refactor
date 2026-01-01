package com.back.global.exception;

import lombok.Getter;

public class ApiException extends RuntimeException {

    @Getter
    private final ErrorDetails errorDetails;

    public ApiException(ErrorDetails errorDetails) {
        super(errorDetails.getMessage());
        this.errorDetails = errorDetails;
    }

    public ApiException(ErrorDetails errorDetails, String message) {
        super(message);
        this.errorDetails = errorDetails;
    }
}
