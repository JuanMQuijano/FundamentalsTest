package com.spring_fundamentals.ExamenFundamentals.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundExcept extends RuntimeException {

    private final String value;

    public ObjectNotFoundExcept(String value) {
        this.value = value;
    }

    @Override
    public String getMessage() {

        String message = super.getMessage();

        if (message == null) {
            message = "";
        }

        return message.concat("(Value " + this.value + " does not exists in database)");
    }

    public String getValue() {
        return value;
    }

}
