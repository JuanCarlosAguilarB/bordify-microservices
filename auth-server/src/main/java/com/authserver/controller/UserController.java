package com.authserver.controller;

import com.authserver.dto.ResponseApi;
import com.authserver.dto.UserRequest;
import com.authserver.exception.BadRequestExceptionApi;
import com.authserver.models.User;
import com.authserver.repository.UserRepository;
import com.authserver.services.RegisterUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final RegisterUserService registerUserService;

    public UserController( RegisterUserService registerUserService) {
        this.registerUserService = registerUserService;
    }


    @PostMapping("/v1/user/")
    public ResponseEntity<ResponseApi> registerUser(@RequestBody UserRequest user){

        registerUserService.register(user);

        ResponseApi messageApi =  ResponseApi.builder()
                .message("user registered successfully")
                .statusCode(201)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(messageApi);

    }

}
