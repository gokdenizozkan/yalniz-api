package dev.patika.plus.yalnizapi.repository;

import dev.patika.plus.yalnizapi.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {
    @Query("SELECT vac FROM Vaccination vac WHERE vac.pet.id = ?1 AND vac.protectionEndDate >= ?2 AND upper(vac.code) = upper(?3)")
    Vaccination findVaccinationThatIsStillIntact(long petId, LocalDate administrationDate, String code);

    List<Vaccination> findAllByPet_IdOrderByProtectionEndDateDesc(long petId);

    List<Vaccination> findAllByProtectionEndDateBetween(LocalDate startDate, LocalDate endDate);
}