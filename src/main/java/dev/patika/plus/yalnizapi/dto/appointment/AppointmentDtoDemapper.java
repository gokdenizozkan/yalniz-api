package dev.patika.plus.yalnizapi.dto.appointment;

import dev.patika.plus.yalnizapi.entity.Appointment;
import dev.patika.plus.yalnizapi.repository.AppointmentRepository;
import dev.patika.plus.yalnizapi.repository.PetRepository;
import dev.patika.plus.yalnizapi.repository.VetRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * This class is used to demap the AppointmentDto to an Appointment object.
 * It creates a new Appointment object, retrieves related-data from related-databases and sets accordingly.
 */
@Service
public class AppointmentDtoDemapper implements Function<AppointmentDto, Appointment> {
    private final AppointmentRepository appointmentRepository;
    private final VetRepository vetRepository;
    private final PetRepository petRepository;

    public AppointmentDtoDemapper(AppointmentRepository appointmentRepository, VetRepository vetRepository, PetRepository petRepository) {
        this.appointmentRepository = appointmentRepository;
        this.vetRepository = vetRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Appointment apply(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();

        if (appointmentDto.id() != null)
            appointment = appointmentRepository.findById(appointmentDto.id()).orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStartDateTime(appointmentDto.startDateTime());
        appointment.setVet(vetRepository.findById(appointmentDto.vetId()).orElseThrow());
        appointment.setPet(petRepository.findById(appointmentDto.petId()).orElseThrow());

        return appointment;
    }
}
