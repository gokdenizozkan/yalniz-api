package com.gokdenizozkan.yalnizapi.config.response;

public class StructuredResponseBuilder {
    private String message;
    private ResponseStatus status;
    private Object data;

    private StructuredResponseBuilder() {

    }

    public static StructuredResponse build(String message, ResponseStatus status, Object data) {
        return new StructuredResponse(message, status, data);
    }

    public static StructuredResponseBuilder create() {
        return new StructuredResponseBuilder();
    }

    public StructuredResponseBuilder message(String message) {
        this.message = message;
        return this;
    }

    public StructuredResponseBuilder status(ResponseStatus status) {
        this.status = status;
        return this;
    }

    public StructuredResponseBuilder data(Object data) {
        this.data = data;
        return this;
    }

    public StructuredResponse build() {
        return new StructuredResponse(message, status, data);
    }
}
