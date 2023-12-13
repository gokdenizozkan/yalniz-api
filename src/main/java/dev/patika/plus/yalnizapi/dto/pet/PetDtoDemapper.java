package dev.patika.plus.yalnizapi.dto.pet;

import dev.patika.plus.yalnizapi.entity.Pet;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PetDtoDemapper implements Function<PetDto, Pet> {
    @Override
    public Pet apply(PetDto petDto) {
        Pet pet = new Pet();

        pet.setId(petDto.id());
        pet.setName(petDto.name());
        pet.setSpecies(petDto.species());
        pet.setBreed(petDto.breed());
        pet.setGender(petDto.gender());
        pet.setColor(petDto.color());
        pet.setBirthDate(petDto.birthDate());

        return pet;
    }
}
