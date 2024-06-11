package com.apigateway.config.filter;

import com.apigateway.config.constants.HeaderConfig;
import com.apigateway.exception.UnauthorizedException;
import com.apigateway.services.JwtService;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config>{

     private final JwtService jwtService;

    public AuthFilter(JwtService jwtService) {
        super(Config.class);
        this.jwtService = jwtService;

    }

    @Override
    public GatewayFilter apply(Config config) {

        return this::filter;
    }


    public String extractToken(HttpHeaders headers) {
        String authHeader = headers.getFirst(HeaderConfig.AUTHORIZATION);

        if (authHeader != null && authHeader.startsWith(HeaderConfig.JWT_TOKEN_PREFIX)) {
            return authHeader.substring(7);
        }

        return null;
    }

    public Boolean isAuthenticated(HttpHeaders headers) {

         String authHeader = headers.getFirst(HeaderConfig.AUTHORIZATION);

         return authHeader != null && authHeader.startsWith(HeaderConfig.JWT_TOKEN_PREFIX);
    }

    private Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        HttpHeaders headers = exchange.getRequest().getHeaders();
        if (!isAuthenticated(headers)) {
            throw new UnauthorizedException("Not authenticated");
        }

        String token = extractToken(headers);

        if (!jwtService.isValidToken(token)) {
            throw new UnauthorizedException("Invalid token");
        }

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//            System.out.println("First post filter");
        })
        );
    }


    public static class Config {


    }



}



