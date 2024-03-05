package com.gokdenizozkan.yalnizapi.dto.owner.request;

public record OwnerUpdateRequest(
        Long id,
        String name,
        String phone,
        String email,
        String address,
        String city
) {}
