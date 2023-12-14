package dev.patika.plus.yalnizapi.entity.response;

import org.springframework.http.HttpStatus;

public record Response<T>(T data, HttpStatus code, String message, Boolean success) {
}
