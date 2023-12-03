package dev.patika.plus.yalnizapi.structures.vaccination;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VaccinationsRepository extends JpaRepository<Vaccination, Long> {
    List<Vaccination> findAllByCodeIgnoreCaseAndAnimal_IdOrderByProtectionEndDateDesc(String code, long animalId);

    List<Vaccination> findAllByAnimal_IdOrderByProtectionEndDateDesc(long animalId);

    List<Vaccination> findAllByProtectionEndDateBetween(LocalDate startDate, LocalDate endDate);
}