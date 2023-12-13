package dev.patika.plus.yalnizapi.dto.workday;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link dev.patika.plus.yalnizapi.entity.Workday}
 */
public record WorkdayDto(Long id, LocalDate date, Long vetId) implements Serializable {
}