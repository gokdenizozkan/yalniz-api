package dev.patika.plus.yalnizapi.dto.vaccination;

import dev.patika.plus.yalnizapi.entity.Vaccination;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class VaccinationDtoMapper implements Function<Vaccination, VaccinationDto> {

    @Override
    public VaccinationDto apply(Vaccination vaccination) {
        return new VaccinationDto(
                vaccination.getId(),
                vaccination.getName(),
                vaccination.getCode(),
                vaccination.getAdministrationDate(),
                vaccination.getProtectionEndDate(),
                vaccination.getPet().getId()
        );
    }
}
