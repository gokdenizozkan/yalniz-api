package com.gokdenizozkan.yalnizapi.dto.owner;

import com.gokdenizozkan.yalnizapi.dto.owner.mapper.OwnerResponseMapper;
import com.gokdenizozkan.yalnizapi.dto.owner.mapper.OwnerSaveRequestDemapper;
import com.gokdenizozkan.yalnizapi.dto.owner.mapper.OwnerUpdateRequestDemapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OwnerEntityMappers {
    public final OwnerSaveRequestDemapper fromSaveRequest;
    public final OwnerUpdateRequestDemapper fromUpdateRequest;
}
