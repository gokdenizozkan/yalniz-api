package com.gokdenizozkan.yalnizapi.dto.appointment;

import com.gokdenizozkan.yalnizapi.dto.appointment.mapper.AppointmentSaveRequestDemapper;
import com.gokdenizozkan.yalnizapi.dto.appointment.mapper.AppointmentUpdateRequestDemapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentEntityMappers {
    public final AppointmentUpdateRequestDemapper fromUpdateRequest;
    public final AppointmentSaveRequestDemapper fromSaveRequest;
}
