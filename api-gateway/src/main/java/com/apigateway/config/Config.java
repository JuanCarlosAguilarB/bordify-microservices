package com.apigateway.config;

import com.apigateway.config.filter.AuthFilter;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {


    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder, AuthFilter authFilter) {
        return builder.routes()
                .route(r -> (Buildable<Route>) r.path("/auth/**")
                                .filters(f -> f.filter(authFilter.apply(new AuthFilter.Config())))
                                .uri("lb://auth-server"))
                .build();
    }

}
