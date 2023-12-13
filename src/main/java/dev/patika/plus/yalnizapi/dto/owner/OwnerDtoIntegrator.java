package dev.patika.plus.yalnizapi.dto.owner;

import dev.patika.plus.yalnizapi.entity.Owner;
import dev.patika.plus.yalnizapi.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class OwnerDtoIntegrator implements Function<OwnerDto, Owner> {
    private final OwnerRepository ownerRepository;

    public OwnerDtoIntegrator(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner apply(OwnerDto ownerDto) {
        Owner owner = ownerRepository.findById(ownerDto.id()).orElseThrow(() -> new RuntimeException("Owner not found"));

        owner.setName(ownerDto.name());
        owner.setPhoneNumber(ownerDto.phoneNumber());
        owner.setEmail(ownerDto.email());
        owner.setAddress(ownerDto.address());
        owner.setCity(ownerDto.city());
        return owner;
    }
}
