package com.gokdenizozkan.yalnizapi.dto.pet;

import com.gokdenizozkan.yalnizapi.dto.pet.mapper.PetSaveRequestDemapper;
import com.gokdenizozkan.yalnizapi.dto.pet.mapper.PetUpdateRequestDemapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PetEntityMappers {
    public final PetSaveRequestDemapper fromSaveRequest;
    public final PetUpdateRequestDemapper fromUpdateRequest;
}
