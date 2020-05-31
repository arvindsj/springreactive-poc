package com.reactivepoc.springreactivepoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class VendorRoutes {

    @Bean
    public RouterFunction<ServerResponse> route(RouterHandlers handler) {
        return RouterFunctions
            .route()
            .GET("/employee/all", accept(MediaType.APPLICATION_JSON), handler::findAll)
            .GET("/external/employee/comments/all", accept(MediaType.APPLICATION_JSON), handler::getEmployeeComments)
            .POST("/employee/save", accept(MediaType.APPLICATION_JSON), handler::createEmployee)
            .GET("/employee/comments/save", accept(MediaType.APPLICATION_JSON), handler::createEmployeeComments)
            .build()
        ;
    }
}
