package dev.patika.plus.yalnizapi.dto.vet;

import java.io.Serializable;

/**
 * DTO for {@link dev.patika.plus.yalnizapi.entity.Vet}
 */
public record VetDto(Long id, String name, String phoneNumber, String email, String address,
                     String city) implements Serializable {
}