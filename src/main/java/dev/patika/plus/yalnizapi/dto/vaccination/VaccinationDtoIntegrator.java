package dev.patika.plus.yalnizapi.dto.vaccination;

import dev.patika.plus.yalnizapi.entity.Vaccination;
import dev.patika.plus.yalnizapi.repository.PetRepository;
import dev.patika.plus.yalnizapi.repository.VaccinationRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * Integrator for {@link Vaccination}
 */
@Service
public class VaccinationDtoIntegrator implements Function<VaccinationDto, Vaccination> {
    private final VaccinationRepository vaccinationRepository;
    private final PetRepository petRepository;

    public VaccinationDtoIntegrator(VaccinationRepository vaccinationRepository, PetRepository petRepository) {
        this.vaccinationRepository = vaccinationRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Vaccination apply(VaccinationDto vaccinationDto) {
        Vaccination vaccination = vaccinationRepository.findById(vaccinationDto.id())
                .orElseThrow(() -> new IllegalArgumentException("Vaccination not found with id: " + vaccinationDto.id()));

        vaccination.setName(vaccinationDto.name());
        vaccination.setCode(vaccinationDto.code());
        vaccination.setAdministrationDate(vaccinationDto.administrationDate());
        vaccination.setProtectionEndDate(vaccinationDto.protectionEndDate());
        vaccination.setPet(petRepository.findById(vaccinationDto.petId())
                .orElseThrow(() -> new IllegalArgumentException("Pet not found with id: " + vaccinationDto.petId())));

        return vaccination;
    }
}
