package com.gokdenizozkan.yalnizapi.dto.vaccination.request;

import java.time.LocalDate;

public record VaccinationUpdateRequest(
        Long id,
        String name,
        String code,
        LocalDate administrationDate,
        LocalDate expirationDate,
        Long petId
) {}
