package com.gokdenizozkan.yalnizapi.dto.pet.mapper;

import com.gokdenizozkan.yalnizapi.dto.pet.response.PetResponse;
import com.gokdenizozkan.yalnizapi.entity.Pet;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PetResponseMapper implements Function<Pet, PetResponse> {
    @Override
    public PetResponse apply(Pet pet) {
        return new PetResponse(
                pet.getId(),
                pet.getName(),
                pet.getSpecies(),
                pet.getBreed(),
                pet.getGender(),
                pet.getColor(),
                pet.getBirthdate(),
                pet.getOwner().getId()
        );
    }
}
