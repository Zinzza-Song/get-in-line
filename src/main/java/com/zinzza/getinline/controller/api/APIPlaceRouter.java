package com.zinzza.getinline.controller.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class APIPlaceRouter {


    @Bean
    public RouterFunction<ServerResponse> placeRouter(APIPlaceHandler apiPlaceHandler) {
        return route()
                .nest(RequestPredicates.path("/api/places"), builder -> builder
                        .GET("", apiPlaceHandler::getPlaces)
                        .POST("", apiPlaceHandler::createPlaces)
                        .GET("/{placeId}", apiPlaceHandler::getPlace)
                        .PUT("/{placeId}", apiPlaceHandler::modifyPlaces)
                        .DELETE("/{placeId}", apiPlaceHandler::removePlaces)
                ).build();
    }

}
