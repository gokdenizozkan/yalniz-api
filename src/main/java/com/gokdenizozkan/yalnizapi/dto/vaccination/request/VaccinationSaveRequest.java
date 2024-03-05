package com.gokdenizozkan.yalnizapi.dto.vaccination.request;

import java.time.LocalDate;

public record VaccinationSaveRequest(
        String name,
        String code,
        LocalDate administrationDate,
        LocalDate expirationDate,
        Long petId
) {
}
