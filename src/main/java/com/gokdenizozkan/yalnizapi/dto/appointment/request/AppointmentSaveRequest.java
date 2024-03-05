package com.gokdenizozkan.yalnizapi.dto.appointment.request;

import java.time.LocalDateTime;

public record AppointmentSaveRequest(
        LocalDateTime start,
        Long petId,
        Long vetId
) {}
