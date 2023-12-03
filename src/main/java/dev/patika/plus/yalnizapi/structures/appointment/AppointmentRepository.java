package dev.patika.plus.yalnizapi.structures.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Set;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findByVetIdAndStartDateTime(int vetId, LocalDateTime startDateTime);

    Set<Appointment> findAllByVetIdAndStartDateTimeBetween(long vetId, LocalDateTime startDateTime, LocalDateTime endLocalDateTime);

    Set<Appointment> findAllByAnimalIdAndStartDateTimeBetween(long animalId, LocalDateTime startLocalDateTime, LocalDateTime endLocalDateTime);
}