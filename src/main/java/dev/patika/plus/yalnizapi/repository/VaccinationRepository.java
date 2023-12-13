package dev.patika.plus.yalnizapi.repository;

import dev.patika.plus.yalnizapi.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {
    List<Vaccination> findAllByCodeIgnoreCaseAndPet_IdOrderByProtectionEndDateDesc(String code, long petId);

    List<Vaccination> findAllByPet_IdOrderByProtectionEndDateDesc(long petId);

    List<Vaccination> findAllByProtectionEndDateBetween(LocalDate startDate, LocalDate endDate);
}