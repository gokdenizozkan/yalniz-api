package com.gokdenizozkan.yalnizapi.dto.appointment;

import com.gokdenizozkan.yalnizapi.dto.appointment.mapper.AppointmentResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentDtoMappers {
    public final AppointmentResponseMapper toResponse;
}
