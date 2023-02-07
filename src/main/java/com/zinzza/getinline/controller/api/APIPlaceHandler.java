package com.zinzza.getinline.controller.api;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.function.ServerResponse.created;
import static org.springframework.web.servlet.function.ServerResponse.ok;

@Component
public class APIPlaceHandler {

    public ServerResponse getPlaces(ServerRequest req) {
        return ok().body(List.of("place1", "place2"));
    }

    public ServerResponse createPlaces(ServerRequest req) {
        return created(URI.create("/api/places/1")).body(true);
    }

    public ServerResponse getPlace(ServerRequest req) {
        return ok().body("place" + req.pathVariable("placeId"));
    }

    public ServerResponse modifyPlaces(ServerRequest req) {
        return ok().body(true);
    }

    public ServerResponse removePlaces(ServerRequest req) {
        return ok().body(true);
    }

}
