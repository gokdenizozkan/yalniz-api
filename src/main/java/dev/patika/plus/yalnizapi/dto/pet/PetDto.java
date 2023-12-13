package dev.patika.plus.yalnizapi.dto.pet;

import dev.patika.plus.yalnizapi.entity.Pet;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Pet}
 */
public record PetDto(Long id, String name, String species, String breed, String gender, String color,
                     LocalDate birthDate,
                     Long ownerId) implements Serializable {
}