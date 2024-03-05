package com.gokdenizozkan.yalnizapi.dto.pet.request;

import java.time.LocalDate;

public record PetSaveRequest(
        String name,
        String species,
        String breed,
        String gender,
        String color,
        LocalDate birthdate,
        Long ownerId
) {
}
