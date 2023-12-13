package dev.patika.plus.yalnizapi.dto.appointment;

import dev.patika.plus.yalnizapi.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AppointmentDtoMapper implements Function<Appointment, AppointmentDto> {

    @Override
    public AppointmentDto apply(Appointment appointment) {
        return new AppointmentDto(
                appointment.getId(),
                appointment.getStartDateTime(),
                appointment.getPet().getId(),
                appointment.getVet().getId()
        );
    }
}
