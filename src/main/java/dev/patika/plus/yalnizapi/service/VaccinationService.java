package dev.patika.plus.yalnizapi.service;

import dev.patika.plus.yalnizapi.dto.vaccination.VaccinationDto;
import dev.patika.plus.yalnizapi.dto.vaccination.VaccinationDtoDemapper;
import dev.patika.plus.yalnizapi.dto.vaccination.VaccinationDtoIntegrator;
import dev.patika.plus.yalnizapi.entity.Vaccination;
import dev.patika.plus.yalnizapi.repository.VaccinationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VaccinationService {
    private final VaccinationRepository vaccinationRepository;
    private final VaccinationDtoDemapper vaccinationDtoDemapper;
    private final VaccinationDtoIntegrator vaccinationDtoIntegrator;

    public VaccinationService(VaccinationRepository vaccinationRepository, VaccinationDtoDemapper vaccinationDtoDemapper, VaccinationDtoIntegrator vaccinationDtoIntegrator) {
        this.vaccinationRepository = vaccinationRepository;
        this.vaccinationDtoDemapper = vaccinationDtoDemapper;
        this.vaccinationDtoIntegrator = vaccinationDtoIntegrator;
    }

    public List<Vaccination> findAll() {
        return vaccinationRepository.findAll();
    }

    public List<Vaccination> findAllByPetId(long petId) {
        return vaccinationRepository.findAllByPet_IdOrderByProtectionEndDateDesc(petId);
    }

    public Vaccination findById(long id) {
        return vaccinationRepository.findById(id).orElseThrow();
    }

    public Vaccination saveByPetId(long petId, VaccinationDto vaccinationDto) {
        Vaccination vaccination = vaccinationDtoDemapper.apply(vaccinationDto);

        // Check if the vaccination is already exists.
        List<Vaccination> vacsOfAnimal = vaccinationRepository.findAllByCodeIgnoreCaseAndPet_IdOrderByProtectionEndDateDesc(vaccination.getCode(), petId);

        if (vacsOfAnimal.isEmpty()) {
            return vaccinationRepository.save(vaccination);
        }

        for (Vaccination vac : vacsOfAnimal) {
            if (vac.getProtectionEndDate().isBefore(vaccination.getAdministrationDate())) {
                throw new RuntimeException("Cannot administer the vaccine because the previous one is still intact.");
            }
        }
        return vaccinationRepository.save(vaccination);
    }

    public Vaccination updateById(long id, VaccinationDto vaccinationDto) {
        VaccinationDto vaccinationDtoWithId = new VaccinationDto(
                id,
                vaccinationDto.name(),
                vaccinationDto.code(),
                vaccinationDto.administrationDate(),
                vaccinationDto.protectionEndDate(),
                vaccinationDto.petId()
        );

        Vaccination vaccination = vaccinationDtoIntegrator.apply(vaccinationDtoWithId);
        return vaccinationRepository.save(vaccination);
    }

    public void deleteById(long id) {
        vaccinationRepository.deleteById(id);
    }

    public List<Vaccination> findAllEndingSoon(LocalDate startDate, LocalDate endDate) {
        return vaccinationRepository.findAllByProtectionEndDateBetween(startDate, endDate);
    }
}
