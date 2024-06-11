package com.apigateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public ResponseEntity<ApiExceptionResponse> handleUnauthorizedException(UnauthorizedException ex) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiExceptionResponse);
    }
}
