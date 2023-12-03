package dev.patika.plus.yalnizapi.structures.vaccination;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VaccinationService {
    private final VaccinationsRepository vaccinationsRepository;

    public VaccinationService(VaccinationsRepository vaccinationsRepository) {
        this.vaccinationsRepository = vaccinationsRepository;
    }

    public Vaccination saveByAnimalId(long animalId, Vaccination vaccination) {
        // Check if the vaccination is already exists.
        List<Vaccination> vacsOfAnimal = vaccinationsRepository.findAllByCodeIgnoreCaseAndAnimal_IdOrderByProtectionEndDateDesc(vaccination.getCode(), animalId);

        if (vacsOfAnimal.isEmpty()) {
            return vaccinationsRepository.save(vaccination);
        }

        for (Vaccination vac : vacsOfAnimal) {
            if (vac.getProtectionEndDate().isBefore(vaccination.getAdministrationDate())) {
                throw new RuntimeException("Cannot administer the vaccine because the previous one is still intact.");
            }
        }
        return vaccinationsRepository.save(vaccination);
    }

    public List<Vaccination> findAll() {
        return vaccinationsRepository.findAll();
    }

    public List<Vaccination> findAllByAnimalId(long animalId) {
        return vaccinationsRepository.findAllByAnimal_IdOrderByProtectionEndDateDesc(animalId);
    }

    public Vaccination findById(long id) {
        return vaccinationsRepository.findById(id).orElseThrow();
    }

    public void updateById(long id, Vaccination vaccination) {
        if (vaccinationsRepository.existsById(id)) {
            vaccination.setId(id);
            vaccinationsRepository.save(vaccination);
        }
    }

    public void deleteById(long id) {
        vaccinationsRepository.deleteById(id);
    }

    public List<Vaccination> findAllEndingSoon(LocalDate startDate, LocalDate endDate) {
        return vaccinationsRepository.findAllByProtectionEndDateBetween(startDate, endDate);
    }
}
