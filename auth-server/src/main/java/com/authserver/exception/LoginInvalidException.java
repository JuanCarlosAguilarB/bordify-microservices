package com.authserver.exception;

public class LoginInvalidException extends  RuntimeException{

    public LoginInvalidException(String message) {
        super(message);
    }

    public LoginInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

}
