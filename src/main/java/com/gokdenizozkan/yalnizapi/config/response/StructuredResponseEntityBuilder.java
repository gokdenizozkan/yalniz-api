package com.gokdenizozkan.yalnizapi.config.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class StructuredResponseEntityBuilder {
    private String message;
    private ResponseStatus status;
    private Object data;
    private HttpStatus httpStatus;

    private StructuredResponseEntityBuilder() {

    }

    public static ResponseEntity<StructuredResponse> build(String message, ResponseStatus status, Object data, HttpStatus httpStatus) {
        StructuredResponse response = StructuredResponseBuilder.build(message, status, data);
        return ResponseEntity.status(httpStatus).body(response);
    }

    public static ResponseEntity<StructuredResponse> success() {
        String message = "The request has been successfully processed.";
        String data = "No data returned.";
        return build(message, ResponseStatus.SUCCESS, data, HttpStatus.OK);
    }

    public static ResponseEntity<StructuredResponse> success(Object data) {
        String message = "The request has been successfully processed.";
        return build(message, ResponseStatus.SUCCESS, data, HttpStatus.OK);
    }

    public static ResponseEntity<StructuredResponse> success(String message, Object data) {
        return build(message, ResponseStatus.SUCCESS, data, HttpStatus.OK);
    }

    public static ResponseEntity<StructuredResponse> error(String message, Object data) {
        return build(message, ResponseStatus.ERROR, data, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static StructuredResponseEntityBuilder create() {
        return new StructuredResponseEntityBuilder();
    }

    public StructuredResponseEntityBuilder message(String message) {
        this.message = message;
        return this;
    }

    public StructuredResponseEntityBuilder status(ResponseStatus status) {
        this.status = status;
        return this;
    }

    public StructuredResponseEntityBuilder data(Object data) {
        this.data = data;
        return this;
    }

    public StructuredResponseEntityBuilder httpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public ResponseEntity<StructuredResponse> build() {
        StructuredResponse response = StructuredResponseBuilder.build(message, status, data);
        return ResponseEntity.status(httpStatus).body(response);
    }

    public ResponseEntity<StructuredResponse> build(HttpStatus httpStatus) {
        StructuredResponse response = StructuredResponseBuilder.build(message, status, data);
        return ResponseEntity.status(httpStatus).body(response);
    }
}
