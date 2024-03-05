package com.gokdenizozkan.yalnizapi.dto.vet.mapper;

import com.gokdenizozkan.yalnizapi.dto.vet.request.VetSaveRequest;
import com.gokdenizozkan.yalnizapi.entity.Vet;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VetSaveRequestDemapper implements Function<VetSaveRequest, Vet> {
    @Override
    public Vet apply(VetSaveRequest vetSaveRequest) {
        Vet vet = new Vet();

        vet.setName(vetSaveRequest.name());
        vet.setPhone(vetSaveRequest.phone());
        vet.setEmail(vetSaveRequest.email());
        vet.setAddress(vetSaveRequest.address());
        vet.setCity(vetSaveRequest.city());

        return vet;
    }
}
