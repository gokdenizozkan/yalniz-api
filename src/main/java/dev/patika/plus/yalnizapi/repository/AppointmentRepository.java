package dev.patika.plus.yalnizapi.repository;

import dev.patika.plus.yalnizapi.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Set;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findByVetIdAndStartDateTime(int vetId, LocalDateTime startDateTime);

    Set<Appointment> findAllByVetIdAndStartDateTimeBetween(long vetId, LocalDateTime startDateTime, LocalDateTime endLocalDateTime);

    boolean existsByVet_IdAndStartDateTimeBetween(Long id, LocalDateTime startDateTimeStart, LocalDateTime startDateTimeEnd);

    Set<Appointment> findAllByPetIdAndStartDateTimeBetween(long animalId, LocalDateTime startLocalDateTime, LocalDateTime endLocalDateTime);
}