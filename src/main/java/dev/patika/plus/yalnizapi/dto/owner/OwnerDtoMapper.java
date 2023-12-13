package dev.patika.plus.yalnizapi.dto.owner;

import dev.patika.plus.yalnizapi.entity.Owner;

import java.util.function.Function;

public class OwnerDtoMapper implements Function<Owner, OwnerDto> {

    @Override
    public OwnerDto apply(Owner owner) {
        return new OwnerDto(
                owner.getId(),
                owner.getName(),
                owner.getPhoneNumber(),
                owner.getEmail(),
                owner.getAddress(),
                owner.getCity()
        );
    }
}
