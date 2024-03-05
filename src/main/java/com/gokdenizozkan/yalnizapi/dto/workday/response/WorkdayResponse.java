package com.gokdenizozkan.yalnizapi.dto.workday.response;

import java.time.LocalDate;

public record WorkdayResponse(
        Long id,
        LocalDate date,
        Long vetId
) {
}
