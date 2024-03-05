package com.gokdenizozkan.yalnizapi.layer.responser;

import com.gokdenizozkan.yalnizapi.config.response.Data;
import com.gokdenizozkan.yalnizapi.config.response.StructuredResponse;
import com.gokdenizozkan.yalnizapi.config.response.StructuredResponseEntityBuilder;
import com.gokdenizozkan.yalnizapi.dto.owner.OwnerDtoMappers;
import com.gokdenizozkan.yalnizapi.dto.owner.request.OwnerSaveRequest;
import com.gokdenizozkan.yalnizapi.dto.owner.request.OwnerUpdateRequest;
import com.gokdenizozkan.yalnizapi.dto.owner.response.OwnerResponse;
import com.gokdenizozkan.yalnizapi.dto.pet.PetDtoMappers;
import com.gokdenizozkan.yalnizapi.dto.pet.response.PetResponse;
import com.gokdenizozkan.yalnizapi.entity.Owner;
import com.gokdenizozkan.yalnizapi.entity.Pet;
import com.gokdenizozkan.yalnizapi.layer.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OwnerResponser {
    private final OwnerService service;
    private final OwnerDtoMappers dtoMappers;
    private final PetDtoMappers petDtoMappers;

    public ResponseEntity<StructuredResponse> findAll() {
        List<Owner> owners = service.findAll();
        List<OwnerResponse> responses = owners.stream().map(dtoMappers.toResponse).toList();
        return StructuredResponseEntityBuilder.success(responses);
    }

    public ResponseEntity<StructuredResponse> findById(Long id) {
        Owner owner = service.findById(id);
        OwnerResponse response = dtoMappers.toResponse.apply(owner);
        return StructuredResponseEntityBuilder.success(response);
    }


    public ResponseEntity<StructuredResponse> search(String name) {
        List<Owner> owners = service.search(name);
        List<OwnerResponse> responses = owners.stream().map(dtoMappers.toResponse).toList();
        return StructuredResponseEntityBuilder.success(responses);
    }

    public ResponseEntity<StructuredResponse> findPetsById(Long id) {
        List<Pet> owners = service.findPetsById(id);
        List<PetResponse> responses = owners.stream().map(petDtoMappers.toResponse).toList();
        return StructuredResponseEntityBuilder.success(responses);
    }

    public ResponseEntity<StructuredResponse> save(OwnerSaveRequest request) {
        Owner owner = service.save(request);
        OwnerResponse response = dtoMappers.toResponse.apply(owner);
        return StructuredResponseEntityBuilder.success(response);
    }


    public ResponseEntity<StructuredResponse> update(Long id, OwnerUpdateRequest request) {
        Data data = service.update(id, request);
        data.map(dtoMappers.toResponse);
        return StructuredResponseEntityBuilder.success(data);
    }

    public ResponseEntity<StructuredResponse> deleteById(Long id) {
        service.deleteById(id);
        return StructuredResponseEntityBuilder.success();
    }
}
