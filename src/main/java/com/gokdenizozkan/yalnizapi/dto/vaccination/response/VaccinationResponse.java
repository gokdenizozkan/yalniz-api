package com.gokdenizozkan.yalnizapi.dto.vaccination.response;

import java.time.LocalDate;

public record VaccinationResponse(
        Long id,
        String name,
        String code,
        LocalDate administrationDate,
        LocalDate expirationDate,
        Long petId
) {}
