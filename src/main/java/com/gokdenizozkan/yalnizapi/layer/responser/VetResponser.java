package com.gokdenizozkan.yalnizapi.layer.responser;

import com.gokdenizozkan.yalnizapi.config.response.Data;
import com.gokdenizozkan.yalnizapi.config.response.StructuredResponse;
import com.gokdenizozkan.yalnizapi.config.response.StructuredResponseEntityBuilder;
import com.gokdenizozkan.yalnizapi.dto.vet.VetDtoMappers;
import com.gokdenizozkan.yalnizapi.dto.vet.request.VetSaveRequest;
import com.gokdenizozkan.yalnizapi.dto.vet.response.VetResponse;
import com.gokdenizozkan.yalnizapi.entity.Vet;
import com.gokdenizozkan.yalnizapi.layer.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VetResponser {
    private final VetService service;
    private final VetDtoMappers dtoMappers;

    public ResponseEntity<StructuredResponse> findAll() {
        List<Vet> vets = service.findAll();
        List<VetResponse> responses = vets.stream().map(dtoMappers.toResponse).toList();
        return StructuredResponseEntityBuilder.success(responses);
    }

    public ResponseEntity<StructuredResponse> findById(Long id) {
        Vet vet = service.findById(id);
        VetResponse response = dtoMappers.toResponse.apply(vet);
        return StructuredResponseEntityBuilder.success(response);
    }

    public ResponseEntity<StructuredResponse> save(VetSaveRequest request) {
        Vet savedVet = service.save(request);
        VetResponse response = dtoMappers.toResponse.apply(savedVet);
        return StructuredResponseEntityBuilder.success(response);
    }

    public ResponseEntity<StructuredResponse> update(Long id, VetSaveRequest request) {
        Data data = service.update(id, request);
        data.map(dtoMappers.toResponse);
        return StructuredResponseEntityBuilder.success(data);
    }

    public ResponseEntity<StructuredResponse> deleteById(Long id) {
        service.deleteById(id);
        return StructuredResponseEntityBuilder.success();
    }
}
