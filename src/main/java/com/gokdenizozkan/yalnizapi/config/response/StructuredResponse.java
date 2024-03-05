package com.gokdenizozkan.yalnizapi.config.response;

public record StructuredResponse(
        String message,
        ResponseStatus status,
        Object data
){}
