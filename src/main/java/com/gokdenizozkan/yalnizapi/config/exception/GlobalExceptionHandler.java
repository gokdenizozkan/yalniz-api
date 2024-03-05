package com.gokdenizozkan.yalnizapi.config.exception;

import com.gokdenizozkan.yalnizapi.config.response.ResponseStatus;
import com.gokdenizozkan.yalnizapi.config.response.StructuredResponse;
import com.gokdenizozkan.yalnizapi.config.response.StructuredResponseEntityBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<StructuredResponse> handleExceptionGeneral(Exception e, WebRequest request) {
        return StructuredResponseEntityBuilder.create()
                .message(e.getMessage())
                .status(ResponseStatus.ERROR)
                .data(Map.of("path", request.getDescription(false)))
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<StructuredResponse> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
        return StructuredResponseEntityBuilder.create()
                .message(e.getMessage())
                .status(ResponseStatus.ERROR)
                .data(Map.of("path", request.getDescription(false)))
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
    }
}
