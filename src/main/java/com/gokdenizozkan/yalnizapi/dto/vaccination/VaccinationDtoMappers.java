package com.gokdenizozkan.yalnizapi.dto.vaccination;

import com.gokdenizozkan.yalnizapi.dto.vaccination.mapper.VaccinationResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VaccinationDtoMappers {
    public final VaccinationResponseMapper toResponse;
}
