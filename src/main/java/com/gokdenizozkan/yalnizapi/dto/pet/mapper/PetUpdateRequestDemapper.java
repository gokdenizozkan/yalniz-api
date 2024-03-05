package com.gokdenizozkan.yalnizapi.dto.pet.mapper;

import com.gokdenizozkan.yalnizapi.config.exception.ResourceNotFoundException;
import com.gokdenizozkan.yalnizapi.dto.pet.request.PetUpdateRequest;
import com.gokdenizozkan.yalnizapi.entity.Pet;
import com.gokdenizozkan.yalnizapi.layer.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class PetUpdateRequestDemapper implements Function<PetUpdateRequest, Pet> {
    private final OwnerRepository ownerRepository;

    @Override
    public Pet apply(PetUpdateRequest request) {
        Pet pet = new Pet();

        pet.setId(request.id());
        pet.setName(request.name());
        pet.setSpecies(request.species());
        pet.setBreed(request.breed());
        pet.setGender(request.gender());
        pet.setColor(request.color());
        pet.setBirthdate(request.birthdate());
        pet.setOwner(ownerRepository.findById(request.ownerId())
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with id " + request.ownerId())));

        return pet;
    }
}
