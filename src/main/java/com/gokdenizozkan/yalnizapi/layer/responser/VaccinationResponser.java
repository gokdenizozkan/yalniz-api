package com.gokdenizozkan.yalnizapi.layer.responser;

import com.gokdenizozkan.yalnizapi.config.response.Data;
import com.gokdenizozkan.yalnizapi.config.response.StructuredResponse;
import com.gokdenizozkan.yalnizapi.config.response.StructuredResponseEntityBuilder;
import com.gokdenizozkan.yalnizapi.dto.vaccination.VaccinationDtoMappers;
import com.gokdenizozkan.yalnizapi.dto.vaccination.request.VaccinationSaveRequest;
import com.gokdenizozkan.yalnizapi.dto.vaccination.request.VaccinationUpdateRequest;
import com.gokdenizozkan.yalnizapi.dto.vaccination.response.VaccinationResponse;
import com.gokdenizozkan.yalnizapi.entity.Vaccination;
import com.gokdenizozkan.yalnizapi.layer.service.VaccinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class VaccinationResponser {
    private final VaccinationService service;
    private final VaccinationDtoMappers dtoMappers;

    public ResponseEntity<StructuredResponse> findAll() {
        List<Vaccination> vaccinations = service.findAll();
        List<VaccinationResponse> responses = vaccinations.stream().map(dtoMappers.toResponse).toList();
        return StructuredResponseEntityBuilder.success(responses);
    }

    public ResponseEntity<StructuredResponse> findById(Long id) {
        Vaccination vaccination = service.findById(id);
        VaccinationResponse response = dtoMappers.toResponse.apply(vaccination);
        return StructuredResponseEntityBuilder.success(response);
    }

    public ResponseEntity<StructuredResponse> findAllByPetId(Long petId) {
        List<Vaccination> vaccinations = service.findAllByPetId(petId);
        List<VaccinationResponse> responses = vaccinations.stream().map(dtoMappers.toResponse).toList();
        return StructuredResponseEntityBuilder.success(responses);
    }

    public ResponseEntity<StructuredResponse> findAllEndingSoon(LocalDate startDate, LocalDate endDate) {
        List<Vaccination> vaccinations = service.findAllEndingSoon(startDate, endDate);
        List<VaccinationResponse> responses = vaccinations.stream().map(dtoMappers.toResponse).toList();
        return StructuredResponseEntityBuilder.success(responses);
    }

    public ResponseEntity<StructuredResponse> saveForPet(Long petId, VaccinationSaveRequest request) {
        Vaccination vaccination = service.saveForPet(petId, request);
        VaccinationResponse response = dtoMappers.toResponse.apply(vaccination);
        return StructuredResponseEntityBuilder.success(response);
    }

    public ResponseEntity<StructuredResponse> update(Long id, VaccinationUpdateRequest request) {
        Data data = service.update(id, request);
        data.map(dtoMappers.toResponse);
        return StructuredResponseEntityBuilder.success(data);
    }

    public ResponseEntity<StructuredResponse> deleteById(Long id) {
        service.deleteById(id);
        return StructuredResponseEntityBuilder.success();
    }
}
