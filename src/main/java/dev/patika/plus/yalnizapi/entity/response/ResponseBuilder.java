package dev.patika.plus.yalnizapi.entity.response;

import org.springframework.http.HttpStatus;

public class ResponseBuilder<T> {
    private T data;
    private HttpStatus code;
    private String message;
    private Boolean success;

    private ResponseBuilder() {
    }

    public static <T> ResponseBuilder<T> of(T data) {
        return new ResponseBuilder<>();
    }

    public static <T> Response<T> templateSuccess(T data) {
        return new Response<>(data, HttpStatus.OK, "Success", true);
    }

    public static <T> Response<T> templateFail(String message) {
        return new Response<>(null, HttpStatus.BAD_REQUEST, message, false);
    }

    public static <T> Response<T> auto(T data, String message) {
        if (data == null) return templateFail(message);
        else return templateSuccess(data);
    }

    public static <T> Response<T> auto(T data) {
        return auto(data, "Request failed");
    }

    public ResponseBuilder<T> data(T data) {
        this.data = data;
        return this;
    }

    public ResponseBuilder<T> code(HttpStatus code) {
        this.code = code;
        return this;
    }

    public ResponseBuilder<T> message(String message) {
        this.message = message;
        return this;
    }

    public ResponseBuilder<T> success(Boolean success) {
        this.success = success;
        return this;
    }

    public Response<T> build() {
        return new Response<>(data, code, message, success);
    }
}
