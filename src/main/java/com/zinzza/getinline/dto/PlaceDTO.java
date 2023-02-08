package com.zinzza.getinline.dto;

import com.zinzza.getinline.constant.PlaceType;

public record PlaceDTO(
        PlaceType placeType,
        String placeName,
        String address,
        String phoneNumber,
        Integer capacity,
        String memo
) {
    public static PlaceDTO of(
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            Integer capacity,
            String memo) {
        return new PlaceDTO(placeType, placeName, address, phoneNumber, capacity, memo);
    }

}
