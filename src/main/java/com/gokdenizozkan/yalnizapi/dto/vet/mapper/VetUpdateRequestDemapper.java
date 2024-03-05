package com.gokdenizozkan.yalnizapi.dto.vet.mapper;

import com.gokdenizozkan.yalnizapi.dto.vet.request.VetUpdateRequest;
import com.gokdenizozkan.yalnizapi.entity.Vet;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VetUpdateRequestDemapper implements Function<VetUpdateRequest, Vet> {
    @Override
    public Vet apply(VetUpdateRequest vetUpdateRequest) {
        Vet vet = new Vet();

        vet.setId(vetUpdateRequest.id());
        vet.setName(vetUpdateRequest.name());
        vet.setPhone(vetUpdateRequest.phone());
        vet.setEmail(vetUpdateRequest.email());
        vet.setAddress(vetUpdateRequest.address());
        vet.setCity(vetUpdateRequest.city());

        return vet;
    }
}
