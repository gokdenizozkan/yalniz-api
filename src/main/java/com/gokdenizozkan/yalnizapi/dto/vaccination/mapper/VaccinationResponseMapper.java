package com.gokdenizozkan.yalnizapi.dto.vaccination.mapper;

import com.gokdenizozkan.yalnizapi.dto.vaccination.response.VaccinationResponse;
import com.gokdenizozkan.yalnizapi.entity.Vaccination;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VaccinationResponseMapper implements Function<Vaccination, VaccinationResponse> {
    @Override
    public VaccinationResponse apply(Vaccination vaccination) {
        return new VaccinationResponse(
                vaccination.getId(),
                vaccination.getName(),
                vaccination.getCode(),
                vaccination.getAdministrationDate(),
                vaccination.getExpirationDate(),
                vaccination.getPet().getId()
        );
    }
}
