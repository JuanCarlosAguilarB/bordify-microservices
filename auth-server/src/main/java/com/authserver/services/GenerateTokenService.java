package com.authserver.services;

import com.auth0.jwt.JWT;
import com.authserver.dto.LoginRequest;
import com.authserver.dto.TokenDto;
import com.authserver.exception.LoginInvalidException;
import com.authserver.exception.UserNotFoundException;
import com.authserver.models.User;
import com.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class GenerateTokenService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEcorder;

    @Value("${jwt.secret}")
    private String secret;

    public TokenDto token(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail());

        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        System.out.println(loginRequest);
        if (!passwordEcorder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new LoginInvalidException("Email or password invalid");
        }

        return TokenDto.builder()
                .accessToken(generateAccessToken(user.getEmail()))
                .refreshToken(generateRefreshToken(user.getEmail()))
                .build();
    }

    public String generateToken(String userName, int minutesToExpire) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(userName)
                .withExpiresAt(new Date(System.currentTimeMillis() + (60000 * minutesToExpire)))
                .sign(algorithm);
    }

    public String generateAccessToken(String userName) {
        int effectiveMinutes = 60 * 6; // 6 hours
        return generateToken(userName, effectiveMinutes);
    }

    public String generateRefreshToken(String userName) {
        int effectiveMinutes = 60 * 24; // 24 hours
        return generateToken(userName, effectiveMinutes);
    }

    public GenerateTokenService(UserRepository userRepository ,BCryptPasswordEncoder passwordEcorder) {
        this.userRepository = userRepository;
        this.passwordEcorder = passwordEcorder;
    }


}
