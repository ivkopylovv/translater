package com.kopylov.translator.exception.handler;

import com.kopylov.translator.exception.IncorrectInputException;
import com.kopylov.translator.mapper.ApiErrorMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity handleHttpMediaTypeNotSupported(
            HttpMediaTypeNotSupportedException e, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        return ApiErrorMapper.errorToEntity(UNSUPPORTED_MEDIA_TYPE, e.getMessage(), request);
    }

    @Override
    protected ResponseEntity handleHttpMessageNotReadable(
            HttpMessageNotReadableException e, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        return ApiErrorMapper.errorToEntity(BAD_REQUEST, e.getMessage(), request);
    }

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(
            MethodArgumentNotValidException e, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        return ApiErrorMapper.errorToEntity(BAD_REQUEST, e.getMessage(), request);
    }

    @Override
    protected ResponseEntity handleMissingServletRequestParameter(
            MissingServletRequestParameterException e, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        return ApiErrorMapper.errorToEntity(BAD_REQUEST, e.getMessage(), request);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException e, WebRequest request) {
        return ApiErrorMapper.errorToEntity(BAD_REQUEST, e.getMessage(), request);
    }

    @ExceptionHandler(IncorrectInputException.class)
    public ResponseEntity handleIncorrectInputException(
            IncorrectInputException e, WebRequest request) {
        return ApiErrorMapper.errorToEntity(BAD_REQUEST, e.getMessage(), request);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(
            RuntimeException e, WebRequest request) {
        return ApiErrorMapper.errorToEntity(INTERNAL_SERVER_ERROR, e.getMessage(), request);
    }

    @Override
    protected ResponseEntity handleNoHandlerFoundException(
            NoHandlerFoundException e, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        return ApiErrorMapper.errorToEntity(BAD_REQUEST, e.getMessage(), request);
    }
}
