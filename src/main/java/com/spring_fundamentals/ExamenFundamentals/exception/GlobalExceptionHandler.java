package com.spring_fundamentals.ExamenFundamentals.exception;

import com.spring_fundamentals.ExamenFundamentals.exception.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class, AlreadyExistsException.class, ObjectNotFoundExcept.class})
    public ResponseEntity<ApiError> handleGenericException(Exception exception) {
        LocalDateTime time = LocalDateTime.now();

        if (exception instanceof AlreadyExistsException alreadyExistsException) {
            return this.handleAlreadyExists(alreadyExistsException, time);
        } else if (exception instanceof ObjectNotFoundExcept objectNotFoundExcept) {
            return this.handleObjectNotFoundExcept(objectNotFoundExcept, time);
        } else {
            return handleException(exception, time);
        }
    }

    private ResponseEntity<ApiError> handleObjectNotFoundExcept(ObjectNotFoundExcept objectNotFoundExcept, LocalDateTime time) {
        int status = HttpStatus.NOT_FOUND.value();

        ApiError apiError = new ApiError(status, objectNotFoundExcept.getMessage(), time);

        return ResponseEntity.status(status).body(apiError);
    }

    private ResponseEntity<ApiError> handleAlreadyExists(AlreadyExistsException alreadyExistsException, LocalDateTime time) {
        int status = HttpStatus.CONFLICT.value();

        ApiError apiError = new ApiError(status, alreadyExistsException.getMessage(), time);

        return ResponseEntity.status(status).body(apiError);
    }

    private ResponseEntity<ApiError> handleException(Exception exception, LocalDateTime time) {
        int httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.value();

        ApiError apiError = new ApiError(
                httpStatus,
                "Oops!, Something went wrong on our server. Please try again later.",
                time
        );

        return ResponseEntity.status(httpStatus).body(apiError);
    }

}
