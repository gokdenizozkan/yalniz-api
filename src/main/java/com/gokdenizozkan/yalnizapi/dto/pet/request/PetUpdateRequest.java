package com.gokdenizozkan.yalnizapi.dto.pet.request;

import java.time.LocalDate;

public record PetUpdateRequest(
        Long id,
        String name,
        String species,
        String breed,
        String gender,
        String color,
        LocalDate birthdate,
        Long ownerId
) {
}
