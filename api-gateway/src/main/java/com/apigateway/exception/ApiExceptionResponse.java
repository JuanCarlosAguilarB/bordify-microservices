package com.apigateway.exception;



import java.time.LocalDateTime;


public class ApiExceptionResponse {
    private LocalDateTime timestamp = LocalDateTime.now();
    private int status;
    private String error;
    private String message;

    public ApiExceptionResponse(int status, String message, String error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
