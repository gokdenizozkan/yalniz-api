package dev.patika.plus.yalnizapi.dto.vet;

import dev.patika.plus.yalnizapi.entity.Vet;
import dev.patika.plus.yalnizapi.repository.VetRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * This class is used to integrate VetDto to an already existing Vet object.
 * Basically, it updates the Vet object with the values from VetDto.
 */
@Service
public class VetDtoIntegrator implements Function<VetDto, Vet> {
    VetRepository vetRepository;

    public VetDtoIntegrator(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet apply(VetDto vetDto) {
        Vet vet = vetRepository.findById(vetDto.id()).orElseThrow(() -> new RuntimeException("Vet not found"));

        vet.setName(vetDto.name());
        vet.setPhoneNumber(vetDto.phoneNumber());
        vet.setEmail(vetDto.email());
        vet.setAddress(vetDto.address());
        vet.setCity(vetDto.city());

        return vet;
    }
}
