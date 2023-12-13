package dev.patika.plus.yalnizapi.dto.appointment;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link dev.patika.plus.yalnizapi.entity.Appointment}
 */
public record AppointmentDto(Long id, LocalDateTime startDateTime, Long petId, Long vetId) implements Serializable {
}