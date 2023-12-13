package dev.patika.plus.yalnizapi.dto.owner;

import dev.patika.plus.yalnizapi.entity.Owner;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * Demapper for {@link OwnerDto}
 */
@Service
public class OwnerDtoDemapper implements Function<OwnerDto, Owner> {

    @Override
    public Owner apply(OwnerDto ownerDto) {
        Owner owner = new Owner();

        if (ownerDto.id() != null) owner.setId(ownerDto.id());
        owner.setName(ownerDto.name());
        owner.setPhoneNumber(ownerDto.phoneNumber());
        owner.setEmail(ownerDto.email());
        owner.setAddress(ownerDto.address());
        owner.setCity(ownerDto.city());

        return owner;
    }
}
