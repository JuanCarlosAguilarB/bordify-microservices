package com.authserver.exception;

public class BadRequestExceptionApi extends RuntimeException{

    public BadRequestExceptionApi(String message) {
        super(message);
    }
    public BadRequestExceptionApi(String message, Throwable cause) {
        super(message, cause);
    }

}
