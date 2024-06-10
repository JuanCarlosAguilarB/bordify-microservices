package com.userserver.controller.user;

import com.userserver.exceptions.InvalidRequestArgumentException;
import com.userserver.utils.EmailValidator;
import lombok.Getter;

@Getter
public class RequestUserBody {
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;

    public void setEmail(String email) {

        if (!EmailValidator.isValidEmail(email) || email == null) {
            throw new InvalidRequestArgumentException("Invalid email");
        }
        this.email = email;
    }
}
