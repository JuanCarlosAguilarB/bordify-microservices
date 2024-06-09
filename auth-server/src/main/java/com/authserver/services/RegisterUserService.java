package com.authserver.services;

import com.authserver.dto.UserRequest;
import com.authserver.exception.BadRequestExceptionApi;
import com.authserver.models.User;
import com.authserver.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {


    UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;


    public void register (UserRequest userRequest){

        Boolean isEmailRegistered = userRepository.existsByEmail(userRequest.getEmail());
        Boolean isUserNameRegistered = userRepository.existsByUserName(userRequest.getUserName());

        if (isEmailRegistered) throw new BadRequestExceptionApi("Error to register user, email has been registered");
        if (isUserNameRegistered) throw new BadRequestExceptionApi("Error to register user, username has been registered");

        User user = User.builder()
                .userName(userRequest.getUserName())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .email(userRequest.getEmail())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .isVerified(true) // TODO: make a strategy for checking email.
                .build();

        userRepository.save(user);
    }

    public RegisterUserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = bCryptPasswordEncoder;
    }

}

