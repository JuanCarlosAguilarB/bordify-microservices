package com.authserver.controller;

import com.authserver.dto.LoginRequest;
import com.authserver.dto.ResponseApi;
import com.authserver.dto.TokenDto;
import com.authserver.services.GenerateTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/v1/login")
public class AuthController {

    private final GenerateTokenService generateTokenService;

    public AuthController( GenerateTokenService generateTokenService ) {
        this.generateTokenService = generateTokenService;
    }


    @PostMapping("/")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest){


        TokenDto token = generateTokenService.token(loginRequest);

        ResponseApi messageApi =  ResponseApi.builder()
                .message("Login successfully")
                .statusCode(HttpStatus.CREATED.value())
                .data(token).build();

        return ResponseEntity.status(HttpStatus.OK).body(messageApi);

    }

}
