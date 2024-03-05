package com.gokdenizozkan.yalnizapi.dto.vet.request;

public record VetUpdateRequest(
        Long id,
        String name,
        String phone,
        String email,
        String address,
        String city
) {
}
