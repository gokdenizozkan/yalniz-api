package dev.patika.plus.yalnizapi.dto.vaccination;

import dev.patika.plus.yalnizapi.entity.Pet;
import dev.patika.plus.yalnizapi.entity.Vaccination;
import dev.patika.plus.yalnizapi.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * Demapper for {@link Vaccination}
 */
@Service
public class VaccinationDtoDemapper implements Function<VaccinationDto, Vaccination> {
    private final PetRepository petRepository;

    public VaccinationDtoDemapper(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Vaccination apply(VaccinationDto vaccinationDto) {
        Pet pet = petRepository.findById(vaccinationDto.petId())
                .orElseThrow(() -> new IllegalArgumentException("Pet not found with id: " + vaccinationDto.petId()));

        Vaccination vaccination = new Vaccination();

        if (vaccinationDto.id() != null) vaccination.setId(vaccinationDto.id());
        vaccination.setName(vaccinationDto.name());
        vaccination.setCode(vaccinationDto.code());
        vaccination.setAdministrationDate(vaccinationDto.administrationDate());
        vaccination.setProtectionEndDate(vaccinationDto.protectionEndDate());
        vaccination.setPet(pet);

        return vaccination;
    }
}
