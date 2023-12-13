package dev.patika.plus.yalnizapi.dto.vet;

import dev.patika.plus.yalnizapi.entity.Vet;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class VetDtoDemapper implements Function<VetDto, Vet> {

    @Override
    public Vet apply(VetDto vetDto) {
        Vet vet = new Vet();

        if (vetDto.id() != null) vet.setId(vetDto.id());
        vet.setName(vetDto.name());
        vet.setPhoneNumber(vetDto.phoneNumber());
        vet.setEmail(vetDto.email());
        vet.setAddress(vetDto.address());
        vet.setCity(vetDto.city());

        return vet;
    }
}
