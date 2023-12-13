package dev.patika.plus.yalnizapi.dto.pet;

import dev.patika.plus.yalnizapi.entity.Pet;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PetDtoMapper implements Function<Pet, PetDto> {

    @Override
    public PetDto apply(Pet pet) {
        return new PetDto(
                pet.getId(),
                pet.getName(),
                pet.getSpecies(),
                pet.getBreed(),
                pet.getGender(),
                pet.getColor(),
                pet.getBirthDate(),
                pet.getOwner().getId()
        );
    }
}
