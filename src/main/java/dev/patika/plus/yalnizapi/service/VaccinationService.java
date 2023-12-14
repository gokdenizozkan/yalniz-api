package dev.patika.plus.yalnizapi.service;

import dev.patika.plus.yalnizapi.dto.vaccination.VaccinationDto;
import dev.patika.plus.yalnizapi.dto.vaccination.VaccinationDtoDemapper;
import dev.patika.plus.yalnizapi.dto.vaccination.VaccinationDtoIntegrator;
import dev.patika.plus.yalnizapi.entity.Vaccination;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.entity.response.ResponseBuilder;
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

    public Response<List<Vaccination>> findAll() {
        return ResponseBuilder.templateSuccess(vaccinationRepository.findAll());
    }

    public Response<List<Vaccination>> findAllByPetId(long petId) {
        return ResponseBuilder.templateSuccess(vaccinationRepository.findAllByPet_IdOrderByProtectionEndDateDesc(petId));
    }

    public Response<Vaccination> findById(long id) {
        return ResponseBuilder.templateSuccess(vaccinationRepository.findById(id).orElse(null));
    }

    public Response<Vaccination> save(VaccinationDto vaccinationDto) {
        Vaccination vaccination = vaccinationDtoDemapper.apply(vaccinationDto);

        Vaccination intactVaccination = vaccinationRepository.findVaccinationThatIsStillIntact(vaccination.getPet().getId(), vaccination.getAdministrationDate(), vaccination.getCode());
        if (intactVaccination != null) {
            return ResponseBuilder.templateFail("Vaccination already intact!");
        }
        return ResponseBuilder.templateSuccess(vaccinationRepository.save(vaccination));
    }

    public Response<Vaccination> update(VaccinationDto vaccinationDto) {
        return ResponseBuilder.templateSuccess(vaccinationRepository.save(vaccinationDtoIntegrator.apply(vaccinationDto)));
    }

    public Response<Vaccination> deleteById(long id) {
        if (!vaccinationRepository.existsById(id)) {
            return ResponseBuilder.templateFail("Vaccination with id " + id + " does not exist!");
        }
        vaccinationRepository.deleteById(id);
        return ResponseBuilder.templateSuccess(null);
    }

    public Response<List<Vaccination>> findAllEndingSoon(LocalDate startDate, LocalDate endDate) {
        return ResponseBuilder.templateSuccess(vaccinationRepository.findAllByProtectionEndDateBetween(startDate, endDate));
    }
}
