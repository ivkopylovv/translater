package com.kopylov.translator.exception.handler;

import com.kopylov.translator.exception.IncorrectInputException;
import com.kopylov.translator.mapper.ApiErrorMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IncorrectInputException.class)
    public ResponseEntity handleIncorrectInputException(IncorrectInputException e, WebRequest request) {
        return ApiErrorMapper.errorToEntity(BAD_REQUEST, e.getMessage(), request);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException e, WebRequest request) {
        return ApiErrorMapper.errorToEntity(INTERNAL_SERVER_ERROR, e.getMessage(), request);
    }
}
