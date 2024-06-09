package com.authserver.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
