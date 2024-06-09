package com.authserver.services;

import com.authserver.dto.LoginRequest;
import com.authserver.dto.TokenDto;
import com.authserver.exception.LoginInvalidException;
import com.authserver.exception.UserNotFoundException;
import com.authserver.models.User;
import com.authserver.repository.UserRepository;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

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
        return Jwts.builder()
                        .setSubject(userName)
                        .setExpiration(new Date(System.currentTimeMillis() + (60000 * minutesToExpire)))
                        .signWith(SignatureAlgorithm.HS256, secret)
                        .compact();
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
