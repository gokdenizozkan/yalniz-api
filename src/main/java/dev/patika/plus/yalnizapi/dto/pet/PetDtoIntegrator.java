package dev.patika.plus.yalnizapi.dto.pet;

import dev.patika.plus.yalnizapi.entity.Pet;
import dev.patika.plus.yalnizapi.repository.OwnerRepository;
import dev.patika.plus.yalnizapi.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * This class is used to integrate PetDto to an already existing Pet object.
 * Basically, it updates the Pet object with the values from PetDto.
 */
@Service
public class PetDtoIntegrator implements Function<PetDto, Pet> {
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public PetDtoIntegrator(OwnerRepository ownerRepository, PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Pet apply(PetDto petDto) {
        Pet pet = petRepository.findById(petDto.id()).orElseThrow(() -> new RuntimeException("Pet not found"));

        pet.setName(petDto.name());
        pet.setSpecies(petDto.species());
        pet.setBreed(petDto.breed());
        pet.setGender(petDto.gender());
        pet.setColor(petDto.color());
        pet.setBirthDate(petDto.birthDate());
        pet.setOwner(ownerRepository.findById(petDto.ownerId()).orElseThrow(() -> new RuntimeException("Owner not found")));

        return pet;
    }
}
