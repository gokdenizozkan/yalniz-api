package com.gokdenizozkan.yalnizapi.dto.vaccination;

import com.gokdenizozkan.yalnizapi.dto.vaccination.mapper.VaccinationSaveRequestDemapper;
import com.gokdenizozkan.yalnizapi.dto.vaccination.mapper.VaccinationUpdateRequestDemapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VaccinationEntityMappers {
    public final VaccinationSaveRequestDemapper fromSaveRequest;
    public final VaccinationUpdateRequestDemapper fromUpdateRequest;
}
