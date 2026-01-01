package com.back.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.annotation.Nullable;
import java.time.LocalDateTime;


/*
 * Global Exception Handler
 *
 * RFC 7807
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ProblemDetail handleApiException(ApiException ex) {
        return createProblemDetail(
                ex.getErrorDetails(),
                ex,
                ex.getErrorDetails().getMessage()
        );
    }

    private ProblemDetail createProblemDetail(ErrorDetails errorDetails, Exception ex, @Nullable String extraMessage) {

        ProblemDetail detail = ProblemDetail.forStatusAndDetail(errorDetails.getHttpStatus(), ex.getMessage());

        detail.setProperty("timestamp", LocalDateTime.now());
        detail.setProperty("exception", ex.getClass().getSimpleName());
        detail.setProperty("errorCode", errorDetails.getCode());

        if (extraMessage != null) {
            detail.setProperty("message", extraMessage);
        }

        log.error("Exception occurred: {}", ex.toString());

        return detail;
    }
}
