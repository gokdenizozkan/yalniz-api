package com.gokdenizozkan.yalnizapi.dto.appointment.request;

import java.time.LocalDateTime;

public record AppointmentUpdateRequest(
        Long id,
        LocalDateTime start,
        Long petId,
        Long vetId
) {}
