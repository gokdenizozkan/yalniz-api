package com.gokdenizozkan.yalnizapi.dto.owner.mapper;

import com.gokdenizozkan.yalnizapi.dto.owner.request.OwnerSaveRequest;
import com.gokdenizozkan.yalnizapi.entity.Owner;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class OwnerSaveRequestDemapper implements Function<OwnerSaveRequest, Owner>{
    @Override
    public Owner apply(OwnerSaveRequest ownerSaveRequest) {
        Owner owner = new Owner();

        owner.setName(ownerSaveRequest.name());
        owner.setPhone(ownerSaveRequest.phone());
        owner.setEmail(ownerSaveRequest.email());
        owner.setAddress(ownerSaveRequest.address());
        owner.setCity(ownerSaveRequest.city());

        return owner;
    }
}
