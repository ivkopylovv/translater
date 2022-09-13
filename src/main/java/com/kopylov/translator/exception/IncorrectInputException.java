package com.kopylov.translator.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(value = BAD_REQUEST)
public class IncorrectInputException extends RuntimeException {
    public IncorrectInputException(String message) {
        super(message);
    }
}
