package dev.patika.plus.yalnizapi.dto.vaccination;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link dev.patika.plus.yalnizapi.entity.Vaccination}
 */
public record VaccinationDto(Long id, String name, String code, LocalDate administrationDate,
                             LocalDate protectionEndDate, Long petId) implements Serializable {
}