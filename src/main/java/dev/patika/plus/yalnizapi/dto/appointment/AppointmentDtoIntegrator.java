package dev.patika.plus.yalnizapi.dto.appointment;

import dev.patika.plus.yalnizapi.entity.Appointment;
import dev.patika.plus.yalnizapi.entity.Pet;
import dev.patika.plus.yalnizapi.entity.Vet;
import dev.patika.plus.yalnizapi.repository.AppointmentRepository;
import dev.patika.plus.yalnizapi.repository.PetRepository;
import dev.patika.plus.yalnizapi.repository.VetRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * This class is used to integrate AppointmentDto to an already existing Appointment object.
 * Basically, it updates the Appointment object with the values from AppointmentDto.
 */
@Service
public class AppointmentDtoIntegrator implements Function<AppointmentDto, Appointment> {
    private final AppointmentRepository appointmentRepository;
    private final VetRepository vetRepository;
    private final PetRepository petRepository;

    public AppointmentDtoIntegrator(AppointmentRepository appointmentRepository, VetRepository vetRepository, PetRepository petRepository) {
        this.appointmentRepository = appointmentRepository;
        this.vetRepository = vetRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Appointment apply(AppointmentDto appointmentDto) {
        Appointment appointment = appointmentRepository.findById(appointmentDto.id()).orElseThrow(() -> new RuntimeException("Appointment not found"));

        if (!(appointment.getVet().getId() == appointmentDto.vetId())) {
            Vet vet = vetRepository.findById(appointmentDto.vetId()).orElseThrow(() -> new RuntimeException("Vet not found"));
            appointment.setVet(vet);
        }

        if (!(appointment.getPet().getId() == appointmentDto.petId())) {
            Pet pet = petRepository.findById(appointmentDto.petId()).orElseThrow(() -> new RuntimeException("Pet not found"));
            appointment.setPet(pet);
        }

        if (!(appointment.getStartDateTime().equals(appointmentDto.startDateTime()))) {
            appointment.setStartDateTime(appointmentDto.startDateTime());
        }

        return appointment;
    }
}
