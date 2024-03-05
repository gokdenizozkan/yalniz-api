package com.gokdenizozkan.yalnizapi.dto.vaccination.mapper;

import com.gokdenizozkan.yalnizapi.config.exception.ResourceNotFoundException;
import com.gokdenizozkan.yalnizapi.dto.vaccination.request.VaccinationSaveRequest;
import com.gokdenizozkan.yalnizapi.entity.Vaccination;
import com.gokdenizozkan.yalnizapi.layer.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class VaccinationSaveRequestDemapper implements Function<VaccinationSaveRequest, Vaccination>{
    private final PetRepository petRepository;

    @Override
    public Vaccination apply(VaccinationSaveRequest vaccinationSaveRequest) {
        Vaccination vaccination = new Vaccination();

        vaccination.setName(vaccinationSaveRequest.name());
        vaccination.setCode(vaccinationSaveRequest.code());
        vaccination.setAdministrationDate(vaccinationSaveRequest.administrationDate());
        vaccination.setExpirationDate(vaccinationSaveRequest.expirationDate());
        vaccination.setPet(petRepository.findById(vaccinationSaveRequest.petId())
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id " + vaccinationSaveRequest.petId())));

        return vaccination;
    }
}
