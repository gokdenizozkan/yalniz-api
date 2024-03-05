package com.gokdenizozkan.yalnizapi.dto.owner.response;

import com.gokdenizozkan.yalnizapi.dto.pet.response.PetResponse;

import java.util.List;

public record OwnerResponse(
        Long id,
        String name,
        String phone,
        String email,
        String address,
        String city,
        List<PetResponse> pets
) {
}
