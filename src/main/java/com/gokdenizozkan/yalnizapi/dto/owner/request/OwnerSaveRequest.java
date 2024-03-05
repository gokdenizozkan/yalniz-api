package com.gokdenizozkan.yalnizapi.dto.owner.request;

public record OwnerSaveRequest(
        String name,
        String phone,
        String email,
        String address,
        String city
) {}
