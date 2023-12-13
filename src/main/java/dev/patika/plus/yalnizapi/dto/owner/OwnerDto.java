package dev.patika.plus.yalnizapi.dto.owner;

import dev.patika.plus.yalnizapi.entity.Owner;

import java.io.Serializable;

/**
 * DTO for {@link Owner}
 */
public record OwnerDto(Long id, String name, String phoneNumber, String email, String address,
                       String city) implements Serializable {
}