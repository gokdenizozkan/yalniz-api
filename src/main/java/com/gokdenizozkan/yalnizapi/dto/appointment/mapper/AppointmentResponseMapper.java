package com.gokdenizozkan.yalnizapi.dto.appointment.mapper;

import com.gokdenizozkan.yalnizapi.dto.appointment.response.AppointmentResponse;
import com.gokdenizozkan.yalnizapi.entity.Appointment;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AppointmentResponseMapper implements Function<Appointment, AppointmentResponse>{
    @Override
    public AppointmentResponse apply(Appointment appointment) {
        return new AppointmentResponse(
                appointment.getId(),
                appointment.getStart(),
                appointment.getEnd(),
                appointment.getPet().getId(),
                appointment.getVet().getId()
        );
    }
}
