package dev.patika.plus.yalnizapi.dto.vet;

import dev.patika.plus.yalnizapi.entity.Vet;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class VetDtoMapper implements Function<Vet, VetDto> {

    @Override
    public VetDto apply(Vet vet) {
        return new VetDto(
                vet.getId(),
                vet.getName(),
                vet.getPhoneNumber(),
                vet.getEmail(),
                vet.getAddress(),
                vet.getCity());
    }
}
