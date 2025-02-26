package com.estudiantes.entudiantes.handlerException;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private final int code;
    private final HttpStatus status;

    public CustomException(String message, int code, HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
