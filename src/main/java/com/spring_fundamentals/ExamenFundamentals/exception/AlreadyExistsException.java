package com.spring_fundamentals.ExamenFundamentals.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyExistsException extends RuntimeException {

    private final String value;

    public AlreadyExistsException(String value) {
        this.value = value;
    }

    @Override
    public String getMessage() {

        String message = super.getMessage();

        if (message == null) {
            message = "";
        }

        return message.concat("(Value: " + this.value + " already exists in database)");
    }

    public String getValue() {
        return value;
    }
}
