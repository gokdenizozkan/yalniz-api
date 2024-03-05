package com.gokdenizozkan.yalnizapi.dto.vet.mapper;

import com.gokdenizozkan.yalnizapi.dto.vet.response.VetResponse;
import com.gokdenizozkan.yalnizapi.entity.Vet;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VetResponseMapper implements Function<Vet, VetResponse> {
    @Override
    public VetResponse apply(Vet vet) {
        return new VetResponse(
                vet.getId(),
                vet.getName(),
                vet.getPhone(),
                vet.getEmail(),
                vet.getAddress(),
                vet.getCity()
        );
    }
}
