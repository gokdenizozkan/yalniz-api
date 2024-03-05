package com.gokdenizozkan.yalnizapi.dto.pet.response;

import java.time.LocalDate;

public record PetResponse(
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
